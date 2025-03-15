package com.medfactor.contrat.listeners;

import com.medfactor.contrat.dtos.UserDto;
import com.medfactor.contrat.dtos.record.TaskEvent;
import com.medfactor.contrat.entities.Contrat;
import com.medfactor.contrat.repos.ContratRepository;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

@Component
public class JuridiqueTaskListener implements TaskListener {

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ContratRepository contratRepository;
    @Override
    public void notify(DelegateTask delegateTask) {
        switch (delegateTask.getEventName()) {
            case "create":
                handleCreate(delegateTask);
                break;
            case "complete":
                handleComplete(delegateTask);
                break;
        }

    }

    private void handleComplete(DelegateTask delegateTask) {
        System.out.println("Juridique task completed");
        Contrat contrat = contratRepository.findById((Long) delegateTask.getVariable("contractId"))
                .orElseThrow(() -> new RuntimeException("Contract not found"));
        contrat.setContratEtape3JuristeDate(new Date());
        contrat.setContratEtape3JuristeNom(delegateTask.getAssignee());
        contratRepository.save(contrat);
        TaskEvent event = new TaskEvent(
                delegateTask.getId(),
                "TASK_COMPLETED",
                Map.of(
                        "decision", delegateTask.getVariable("reviewDecision"),
                        "juriste",delegateTask.getVariable("juristeId")
                )
        );

        kafkaTemplate.send("task-events","system",event);
    }

    private void handleCreate(DelegateTask delegateTask) {

        String jwtToken = (String) delegateTask.getVariable("token");
        // Call the new endpoint to get users by role
        String url = "http://localhost:8082/factoring/users/api/user/usersByRole/" + "ROLE_RES_JURIDIQUE";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", "JWT_TOKEN=" +jwtToken);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Fetch users from the new endpoint
        UserDto[] users = restTemplate.exchange(url, HttpMethod.GET, entity, UserDto[].class).getBody();
        System.out.println("Fetched users: " + Arrays.toString(users));
        if(users!=null){
            TaskEvent event = new TaskEvent(
                    delegateTask.getId(),
                    "TASK_CREATED",
                    Map.of(
                            "contractId", delegateTask.getVariable("contractId"),
                            "processInstanceId", delegateTask.getProcessInstanceId()
                    )
            );
            for(UserDto user:users){
                kafkaTemplate.send("task-events",user.getId().toString(),event);
            }
        }


    }
}

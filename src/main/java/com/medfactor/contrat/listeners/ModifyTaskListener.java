package com.medfactor.contrat.listeners;

import com.medfactor.contrat.dtos.UserDto;
import com.medfactor.contrat.dtos.record.TaskEvent;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class ModifyTaskListener implements TaskListener {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    KafkaTemplate<String, Object> kafkaTemplate;
    @Override
    public void notify(DelegateTask delegateTask) {
        if(delegateTask.getEventName().equals("create")){
            handleCreate(delegateTask);
        }
    }

    private void handleCreate(DelegateTask delegateTask) {


        Long userId = (Long) delegateTask.getVariable("userId");

        String jwtToken = (String) delegateTask.getVariable("token"); // Get JWT token from DelegateTask variable
        String url = "http://localhost:8082/factoring/users/api/user/" + userId.toString();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", "JWT_TOKEN=" +jwtToken);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Fetch users from the new endpoint
        UserDto user = restTemplate.exchange(url, HttpMethod.GET, entity, UserDto.class).getBody();
        delegateTask.getProcessEngineServices()
                .getTaskService()
                .setAssignee(delegateTask.getId(), user.getFirstName() + " " + user.getLastName());



        TaskEvent event=new TaskEvent(
                delegateTask.getId(),
                "TASK_CREATED",
                Map.of(
                        "userId",userId,
                        "user",user
                )

        );

        kafkaTemplate.send("task-events",userId.toString(),event);
    }


}

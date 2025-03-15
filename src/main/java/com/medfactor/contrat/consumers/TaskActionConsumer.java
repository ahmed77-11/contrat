package com.medfactor.contrat.consumers;

import com.medfactor.contrat.dtos.TaskAction;
import com.medfactor.contrat.security.RequestContextHolder;
import com.medfactor.contrat.dtos.UserDto;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.camunda.bpm.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TaskActionConsumer {

    @Autowired
    private TaskService taskService;

    @Autowired
    private RestTemplate restTemplate;

    @KafkaListener(topics = "task-actions", groupId = "contract-service-group", containerFactory = "taskActionContainerFactory")
    public void handleTaskAction(
            ConsumerRecord<String, TaskAction> record,
            @Header(value = "JWT_TOKEN", required = false) String token
    ) {
        try {


            TaskAction taskAction = record.value();

            switch (taskAction.getActionType()) {
                case CLAIM -> {
                    // Fetch user details using RestTemplate
                    String url = "http://localhost:8082/factoring/users/api/user/" + taskAction.getUserId();
                    HttpHeaders headers = new HttpHeaders();
                    headers.add("Cookie", "JWT_TOKEN=" + taskAction.getVariables().get("token"));
                    HttpEntity<String> entity = new HttpEntity<>(headers);

                    ResponseEntity<UserDto> response = restTemplate.exchange(url, HttpMethod.GET, entity, UserDto.class);
                    UserDto userDto = response.getBody();

                    if (userDto == null) {
                        throw new RuntimeException("User not found");
                    }

                    System.out.println("Claiming task: " + taskAction.getTaskId() + " for user: " + userDto.getFirstName() + " " + userDto.getLastName());

                    taskService.claim(taskAction.getTaskId(), userDto.getFirstName() + " " + userDto.getLastName());
                }
                case COMPLETE -> {
                    // Complete the task
                    taskService.complete(taskAction.getTaskId(), taskAction.getVariables());
                }
            }
        } catch (Exception e) {
            System.out.println("Error processing task action: " + e.getMessage());
        } finally {
            RequestContextHolder.clear();
        }
    }
}

package com.medfactor.contrat.config.kafka;


import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.internals.Topic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic taskEventsTopic(){
        return TopicBuilder.name("task-events")
                .partitions(3)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic taskActionsTopic(){
        return TopicBuilder.name("task-actions")
                .partitions(3)
                .replicas(1)
                .build();
    }



}

package com.medfactor.contrat.config.kafka;

import com.medfactor.contrat.dtos.TaskAction;
import com.medfactor.contrat.dtos.record.TaskEvent;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {

    // Common configuration
    private Map<String, Object> baseConsumerConfig() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "contract-service-group");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        return props;
    }

    // TaskEvent Consumer
    @Bean
    public ConsumerFactory<String, TaskEvent> taskEventConsumerFactory() {
        Map<String, Object> props = baseConsumerConfig();
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "com.medfactor.contrat.dtos.record");
        props.put(JsonDeserializer.USE_TYPE_INFO_HEADERS, false);
        props.put(JsonDeserializer.VALUE_DEFAULT_TYPE, TaskEvent.class.getName());

        return new DefaultKafkaConsumerFactory<>(
                props,
                new StringDeserializer(),
                new JsonDeserializer<>(TaskEvent.class)
        );
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, TaskEvent> taskEventListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, TaskEvent> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(taskEventConsumerFactory());
        return factory;
    }

    // TaskAction Consumer
    @Bean
    public ConsumerFactory<String, TaskAction> taskActionConsumerFactory() {
        Map<String, Object> props = baseConsumerConfig();
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "com.medfactor.contrat.dtos");
        props.put(JsonDeserializer.USE_TYPE_INFO_HEADERS, false);
        props.put(JsonDeserializer.VALUE_DEFAULT_TYPE, TaskAction.class.getName());

        return new DefaultKafkaConsumerFactory<>(
                props,
                new StringDeserializer(),
                new JsonDeserializer<>(TaskAction.class)
        );
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, TaskAction> taskActionContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, TaskAction> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(taskActionConsumerFactory());
        return factory;
    }
}
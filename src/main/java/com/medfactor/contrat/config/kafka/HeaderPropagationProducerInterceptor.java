package com.medfactor.contrat.config.kafka;

import com.medfactor.contrat.security.RequestContextHolder;
import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

public class HeaderPropagationProducerInterceptor implements ProducerInterceptor<String, Object> {

    @Override
    public ProducerRecord<String, Object> onSend(ProducerRecord<String, Object> record) {
        String jwt = RequestContextHolder.getJwtToken();
        if (jwt != null) {
            record.headers().add("JWT_TOKEN", jwt.getBytes());
        }
        return record;
    }

    @Override
    public void onAcknowledgement(RecordMetadata recordMetadata, Exception e) {

    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }

    // ... other required interceptor methods ...
}
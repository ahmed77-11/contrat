package com.medfactor.contrat.dtos.record;

import lombok.Data;

import java.util.Map;


public record TaskEvent(
        String taskId,
        String eventType,
        Map<String ,Object> payload
) {
}

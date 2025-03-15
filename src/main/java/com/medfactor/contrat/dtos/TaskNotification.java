package com.medfactor.contrat.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskNotification {
    private String taskId;
    private Long contractId;
    private String eventType;
    private Map<String, Object> metadata;
}

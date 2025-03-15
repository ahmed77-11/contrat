package com.medfactor.contrat.dtos;

import com.medfactor.contrat.enums.ActionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskAction {
    private String taskId;
    private ActionType actionType;
    private String userId;
    private Map<String,Object> variables;
}

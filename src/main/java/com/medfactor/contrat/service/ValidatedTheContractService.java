package com.medfactor.contrat.service;

import com.medfactor.contrat.dtos.record.TaskEvent;
import com.medfactor.contrat.entities.Contrat;
import com.medfactor.contrat.repos.ContratRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ValidatedTheContractService implements JavaDelegate {
    @Autowired
    private ContratRepository contratRepository;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;
    @Override
    public void execute(DelegateExecution execution) throws Exception {

        Long contratId = (Long) execution.getVariable("contractId");

        Contrat contrat=contratRepository.findById(contratId).orElseThrow(()->new RuntimeException("Contrat not found"));
        contrat.setContratValider(true);
        contratRepository.save(contrat);
        TaskEvent event = new TaskEvent(
                execution.getCurrentActivityId(),
                "Contrat_Valider",
                Map.of(
                        "contratId", contratId
                )
        );
        kafkaTemplate.send("task-events","system",event);
    }


}

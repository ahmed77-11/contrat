package com.medfactor.contrat.service;

import com.medfactor.contrat.clients.UserClient;
import com.medfactor.contrat.dtos.ContratDTO;
import com.medfactor.contrat.dtos.UserDto;
import com.medfactor.contrat.dtos.mappers.ContratMapper;
import com.medfactor.contrat.entities.Contrat;
import com.medfactor.contrat.repos.CommissionRepository;
import com.medfactor.contrat.repos.ContratFondsRepository;
import com.medfactor.contrat.repos.ContratRepository;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.camunda.spin.Spin;
import org.camunda.spin.json.SpinJsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ContratServiceImpl implements ContratService{

    @Autowired
    private ContratRepository contratRepository;

    @Autowired
    private ContratFondsRepository contratFondsRepository;

    @Autowired
    private CommissionRepository commissionRepository;

    @Autowired
    private UserClient userClient;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;


    @Override
    public Contrat createContrat(ContratDTO request,String token) {
        Contrat contrat= ContratMapper.INSTANCE.toEntity(request);
        Contrat savedContrat = contratRepository.save(contrat);
        request.getContratFonds().forEach(contratFond -> {
            contratFond.setContratId(savedContrat);
            contratFondsRepository.save(contratFond);
        });
        request.getCommissions().forEach(commission -> {
            commission.setContrat(savedContrat);
            commissionRepository.save(commission);
        });
        UserDto userDto = userClient.getUserById(request.getSysUserId()).orElseThrow(()->new RuntimeException("User not found"));
        savedContrat.setContratEtape1RedacteurNom(userDto.getFirstName()+" "+userDto.getLastName());
        savedContrat.setContratEtape1RedacteurDate(new Date());
        Map<String, Object> variables = new HashMap<>();
        SpinJsonNode contractJson = Spin.JSON(request);

        variables.put("contractData", request);
        variables.put("contractId", savedContrat.getId());
        variables.put("userId", request.getSysUserId());
        variables.put("token", token);

        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("contract-creation-process", variables);

        // ✅ Complete the "Remplir le formulaire du contrat" user task
        Task task = taskService.createTaskQuery()
                .processInstanceId(processInstance.getId())
                .taskDefinitionKey("UserTask_FillContractForm")
                .singleResult();

        if (task != null) {

            taskService.claim(task.getId(), userDto.getFirstName()+" "+userDto.getLastName());

            taskService.complete(task.getId());
        }

        return savedContrat;
    }

    @Override
    public Contrat updateContrat(ContratDTO request, String taskId, String token) {
        Contrat contrat= ContratMapper.INSTANCE.toEntity(request);
        System.out.println("contrat: "+contrat);
        Contrat savedContrat = contratRepository.save(contrat);
        request.getContratFonds().forEach(contratFond -> {
            contratFond.setContratId(savedContrat);
            contratFondsRepository.save(contratFond);
        });
        request.getCommissions().forEach(commission -> {
            commission.setContrat(savedContrat);
            commissionRepository.save(commission);
        });
        Map<String, Object> variables = new HashMap<>();
        SpinJsonNode contractJson = Spin.JSON(request);

        variables.put("contractData", request);
        taskService.complete(taskId,variables);
        return savedContrat;
    }


    @Override
    public Optional<Contrat> getContratById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Contrat> getContratByContratNo(String contratNo) {
        return Optional.empty();
    }

    @Override
    public List<Contrat> getAllContrats() {
        return null;
    }
}

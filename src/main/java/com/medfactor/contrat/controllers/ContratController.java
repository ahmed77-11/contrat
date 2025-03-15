package com.medfactor.contrat.controllers;


import com.medfactor.contrat.dtos.ContratDTO;
import com.medfactor.contrat.entities.Contrat;
import com.medfactor.contrat.service.ContratService;
import jakarta.servlet.http.HttpServletRequest;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class ContratController {

    @Autowired
    private ContratService contratService;




    @PostMapping("/create-contrat")
    public Contrat createContrat(@RequestBody ContratDTO contratDTO, HttpServletRequest request){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.getDetails());
        contratDTO.setSysAdresseIp((String) request.getAttribute("clientIp"));
        System.out.println("clientIp: "+request.getAttribute("clientIp"));
        contratDTO.setSysUser(auth.getName());
        contratDTO.setSysUserId((Long) request.getAttribute("userId"));
        String token= (String) request.getAttribute("JWT_TOKEN");
        Contrat contrat=contratService.createContrat(contratDTO,token);
        return contrat;
    }
    @PostMapping("/update-contrat/{taskId}")
    public Contrat updateContrat(@PathVariable("taskId") String taskId, @RequestBody ContratDTO contratDTO, HttpServletRequest request){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.getDetails());
        contratDTO.setSysAdresseIp((String) request.getAttribute("clientIp"));
        System.out.println("clientIp: "+request.getAttribute("clientIp"));
        contratDTO.setSysUser(auth.getName());
        contratDTO.setSysUserId((Long) request.getAttribute("userId"));
        String token= (String) request.getAttribute("JWT_TOKEN");
        Contrat contrat=contratService.updateContrat(contratDTO,taskId,token);
        return contrat;
    }
}

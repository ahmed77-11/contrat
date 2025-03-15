package com.medfactor.contrat.service;

import com.medfactor.contrat.dtos.ContratDTO;
import com.medfactor.contrat.entities.Contrat;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ContratService {
    Contrat createContrat(ContratDTO request,String token);
   Contrat updateContrat(ContratDTO request,String taskId,String token);
    Optional<Contrat> getContratById(Long id);
    Optional<Contrat> getContratByContratNo(String contratNo);
    List<Contrat> getAllContrats();

}

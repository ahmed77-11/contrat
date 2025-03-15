package com.medfactor.contrat.repos;

import com.medfactor.contrat.entities.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContratRepository extends JpaRepository<Contrat, Long> {
    Optional<Contrat> findByContratNo(String contratNo);

}

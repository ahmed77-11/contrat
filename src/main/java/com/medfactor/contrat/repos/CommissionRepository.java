package com.medfactor.contrat.repos;

import com.medfactor.contrat.entities.Commission;
import com.medfactor.contrat.entities.Contrat;
import com.medfactor.contrat.entities.TypeComm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommissionRepository extends JpaRepository<Commission, Long> {
    Optional<Commission> findByContrat(Contrat contrat);
    Optional<Commission> findByTypeComm(TypeComm typeComm);

    Optional<Commission> findByCommId(Long commId);
}

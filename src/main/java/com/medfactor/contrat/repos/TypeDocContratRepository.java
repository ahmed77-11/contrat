package com.medfactor.contrat.repos;

import com.medfactor.contrat.entities.TypeDocContrat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeDocContratRepository extends JpaRepository<TypeDocContrat, String> {
}

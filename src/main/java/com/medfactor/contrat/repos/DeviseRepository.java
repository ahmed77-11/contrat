package com.medfactor.contrat.repos;

import com.medfactor.contrat.entities.Devise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviseRepository extends JpaRepository<Devise, String> {
}

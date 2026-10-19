package com.example.Entreprise.infrastructure;

import com.example.Entreprise.application.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {
}

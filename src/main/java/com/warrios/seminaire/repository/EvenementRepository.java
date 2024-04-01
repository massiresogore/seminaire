package com.warrios.seminaire.repository;

import com.warrios.seminaire.modeles.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvenementRepository extends JpaRepository<Evenement, Integer> {
}

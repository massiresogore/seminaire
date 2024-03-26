package com.warrios.seminaire.repository;

import com.warrios.seminaire.modeles.Calendrier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendrierRepository extends JpaRepository<Calendrier, Integer> {
}

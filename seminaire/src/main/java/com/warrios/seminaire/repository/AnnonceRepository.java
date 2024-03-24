package com.warrios.seminaire.repository;

import com.warrios.seminaire.models.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnonceRepository extends JpaRepository<Annonce, Integer> {
}

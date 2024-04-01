package com.warrios.seminaire.repository;


import com.warrios.seminaire.modeles.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CommentaireRepository extends JpaRepository<Commentaire, Integer> {

}

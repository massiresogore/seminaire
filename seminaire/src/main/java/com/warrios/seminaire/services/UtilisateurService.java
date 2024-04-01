package com.warrios.seminaire.services;

import com.warrios.seminaire.exception.ObjectNotFoundException;
import com.warrios.seminaire.modeles.Utilisateur;
import com.warrios.seminaire.repository.UtilisateurRepository;
import com.warrios.seminaire.services.crudInterface.CrudInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService implements CrudInterface<Utilisateur> {

    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public Utilisateur findById(Integer id){

       return this.utilisateurRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException("utilisateur", id));
    }

    public List<Utilisateur> findAll(){

        return  this.utilisateurRepository.findAll();
    }

    public Utilisateur save(Utilisateur user){
      return this.utilisateurRepository.save(user);
    }

    public void delete(Integer id){

        //Rechercher utilisateur si non , leve une exception
        this.findById(id);

        this.utilisateurRepository.deleteById(id);
    }

    public Utilisateur update(Utilisateur update, Integer id){

        //Rechercher utilisateur si non , leve une exception
        Utilisateur oldUtilisateur = this.findById(id);

        oldUtilisateur.setId_user(update.getId_user());
        oldUtilisateur.setNom(update.getNom());
        oldUtilisateur.setPrenom(update.getPrenom());
        oldUtilisateur.setAffectation(update.getAffectation());
        oldUtilisateur.setUrl(update.getUrl());
        oldUtilisateur.setLogin(update.getLogin());
        oldUtilisateur.setMdp(update.getMdp());
        oldUtilisateur.setEmail(update.getEmail());
        oldUtilisateur.setTelephone(update.getTelephone());
        return oldUtilisateur;

    }
}















































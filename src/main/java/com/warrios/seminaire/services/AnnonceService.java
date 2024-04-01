package com.warrios.seminaire.services;

import com.warrios.seminaire.exception.ObjectNotFoundException;
import com.warrios.seminaire.modeles.Annonce;
import com.warrios.seminaire.repository.AnnonceRepository;
import com.warrios.seminaire.services.crudInterface.CrudInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnonceService implements CrudInterface<Annonce> {
    private final AnnonceRepository annonceRepository;

    public AnnonceService(AnnonceRepository annonceRepository) {
        this.annonceRepository = annonceRepository;
    }

    @Override
    public Annonce findById(Integer id) {
        return annonceRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("annonce",id));
    }

    @Override
    public List<Annonce> findAll() {
        return annonceRepository.findAll();
    }

    @Override
    public Annonce save(Annonce annonce) {
        return annonceRepository.save(annonce);
    }

    @Override
    public void delete(Integer id) {
        this.findById(id);
        this.annonceRepository.deleteById(id);
    }

    @Override
    public Annonce update(Annonce update, Integer id) {
        Annonce oldAnnonce=this.findById(id);
        oldAnnonce.setDate(update.getDate());
        oldAnnonce.setTitre(update.getTitre());
        oldAnnonce.setLieu(update.getLieu());
        oldAnnonce.setDate_update(update.getDate_update());
        oldAnnonce.setEvenement(update.getEvenement());
        oldAnnonce.setUtilisateur(update.getUtilisateur());
        return annonceRepository.save(oldAnnonce);
    }
}

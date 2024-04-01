package com.warrios.seminaire.services;



import com.warrios.seminaire.exception.ObjectNotFoundException;
import com.warrios.seminaire.modeles.Evenement;
import com.warrios.seminaire.repository.EvenementRepository;
import com.warrios.seminaire.services.crudInterface.CrudInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvenementService implements CrudInterface<Evenement> {

    public final EvenementRepository evenementRepository;

    public EvenementService(EvenementRepository evenementRepository){
        this.evenementRepository=evenementRepository;
    }
 @Override
    public Evenement findById(Integer id){
        return evenementRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("evenement",id));
    }
 @Override
    public List<Evenement> findAll(){
        return evenementRepository.findAll();
    }
 @Override
    public Evenement save(Evenement evenement){
        return evenementRepository.save(evenement);

    }
 @Override
    public void delete(Integer id){
        this.findById(id);
        this.evenementRepository.deleteById(id);
    }
 @Override
    public Evenement update(Evenement evenement, Integer id){
        Evenement oldEvent= this.findById(id);
        oldEvent.setUtilisateur(evenement.getUtilisateur());
        oldEvent.setAdresse(evenement.getAdresse());
        oldEvent.setDescription_evenement(evenement.getDescription_evenement());
        oldEvent.setTheme(evenement.getTheme());

        return evenementRepository.save(oldEvent);

    }

}

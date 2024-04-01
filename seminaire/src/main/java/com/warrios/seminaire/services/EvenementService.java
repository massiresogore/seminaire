package com.warrios.seminaire.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warrios.seminaire.repository.EvenementRepository;
import com.warrios.seminaire.modeles.Evenement;



@Service
public class EvenementService {
	
	@Autowired
	EvenementRepository evenementRepository;
	
	
	public Evenement createEvenement( Evenement event) {
		return evenementRepository.save(event);
	}
	
	public Evenement getEvenementById(Integer id) {
		Optional<Evenement> event=evenementRepository.findById(id);
		return event.isPresent()? event.get() : null; 
	}
	
	public List <Evenement> getEvenement(){
		return evenementRepository.findAll();
	}
	
	public void deleteEvenementById(Integer id) {
		evenementRepository.deleteById(id);
	}
	public void deleteEvenement(Evenement event) {
		evenementRepository.delete(event);
	}
	public Evenement updateEvenement(Integer id, Evenement evenementToUp) {
		Optional<Evenement> opEvent=evenementRepository.findById(id);
		if(opEvent.isPresent()) {
			Evenement eventInBd=opEvent.get();
			eventInBd.setAdresse(evenementToUp.getAdresse());
			eventInBd.setDescription_evenement(evenementToUp.getDescription_evenement());
			eventInBd.setTheme(evenementToUp.getTheme());
			
			return evenementRepository.save(eventInBd);
		}
		return null;
	}
}

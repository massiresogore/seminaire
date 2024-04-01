package com.warrios.seminaire.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warrios.seminaire.modeles.Calendrier;
import com.warrios.seminaire.repository.CalendrierRepository;

@Service
public class CalendrierService {
	
	@Autowired
	CalendrierRepository calendrierRepository;
	
	public Calendrier createCalendrier(Calendrier calendar) {
		return calendrierRepository.save(calendar);
	}
	
	public Calendrier getCalendrierById(Integer id) {
		Optional<Calendrier> calendar=calendrierRepository.findById(id);
		return calendar.isPresent()? calendar.get():null ;
	}
	
	public List<Calendrier> getCalendriers() {
		return calendrierRepository.findAll();
	}
	
	public void deleteCalendrierById(Integer id) {
		calendrierRepository.deleteById(id);
	}
	
	public void deleteCalendrier(Calendrier calendar) {
		calendrierRepository.delete(calendar);
	}
	
	public Calendrier updateCalendrier(Integer id,Calendrier calendarToUp) {
		Optional<Calendrier> opCal=calendrierRepository.findById(id);
		
		if(opCal.isPresent()) {
			Calendrier calendarInBd=opCal.get();
			calendarInBd.setDate_calendrier(calendarToUp.getDate_calendrier());
			return calendrierRepository.save(calendarInBd);
			
		}
		return null;
	}

}

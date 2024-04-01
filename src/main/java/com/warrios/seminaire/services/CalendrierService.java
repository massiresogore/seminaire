package com.warrios.seminaire.services;

import com.warrios.seminaire.exception.ObjectNotFoundException;
import com.warrios.seminaire.modeles.Calendrier;
import com.warrios.seminaire.repository.CalendrierRepository;
import com.warrios.seminaire.services.crudInterface.CrudInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendrierService implements CrudInterface<Calendrier> {

    private final CalendrierRepository calendrierRepository;

    public CalendrierService(CalendrierRepository calendrierRepository){
        this.calendrierRepository=calendrierRepository;
    }
    @Override
    public Calendrier findById(Integer id){
        return calendrierRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("calendrier",id));
    }
    @Override
    public List<Calendrier> findAll(){
        return calendrierRepository.findAll();
    }
    @Override
    public Calendrier save(Calendrier calendrier){
        return calendrierRepository.save(calendrier);
    }
    @Override
    public void delete(Integer id){
        this.findById(id);
        this.calendrierRepository.deleteById(id);
    }
    @Override
    public Calendrier update(Calendrier upCalendar, Integer id ){
        Calendrier oldCalendar=this.findById(id);
        oldCalendar.setUtilisateur(upCalendar.getUtilisateur());
        oldCalendar.setDate_calendrier(upCalendar.getDate_calendrier());

        return calendrierRepository.save(oldCalendar);
    }
}

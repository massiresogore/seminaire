package com.warrios.seminaire.modeles;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Calendrier {
	@Id 
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id_calendrier;
	private Date date_calendrier;

}

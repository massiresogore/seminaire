package com.warrios.seminaire.modeles;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Evenement {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_evenement;
	private String adresse;
	private Date adresse_evenement;
	private String description_evenement;


}

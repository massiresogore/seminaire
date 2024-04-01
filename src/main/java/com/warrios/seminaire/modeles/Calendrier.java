package com.warrios.seminaire.modeles;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Calendrier {
	@Id 
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id_calendrier;
	private Date date_calendrier;

	@ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

	@ManyToMany
	@JoinTable(
			name = "planning",
			joinColumns = @JoinColumn(name = "calendrier_id"),
			inverseJoinColumns = @JoinColumn(name = "evenement_id")
	)
	List<Evenement> evenementList = new ArrayList<>();





}

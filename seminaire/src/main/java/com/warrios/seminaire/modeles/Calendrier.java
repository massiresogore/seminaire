package com.warrios.seminaire.modeles;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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

	@OneToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;
	
	 @OneToMany(mappedBy = "calendrier")
	 private List<Evenement> evenements = new ArrayList<>();
}

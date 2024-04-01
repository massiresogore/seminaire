package com.warrios.seminaire.modeles;

import java.time.LocalDate;
import java.util.ArrayList;
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
	private LocalDate date_calendrier;

	@ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "planning",
			joinColumns = @JoinColumn(name = "calendrier_id"),
			inverseJoinColumns = @JoinColumn(name = "evenement_id")
	)
	List<Evenement> evenementList;

	public Calendrier(LocalDate date_calendrier) {
		this.date_calendrier = date_calendrier;
	}

	public Calendrier(LocalDate date_calendrier, Utilisateur utilisateur) {
		this.date_calendrier = date_calendrier;
		this.utilisateur = utilisateur;
	}

	/*Add evenement*/
	public void addEvenement(Evenement evenement){
		if(evenementList==null){
			evenementList = new ArrayList<>();
		}

		evenementList.add(evenement);
	}

	@Override
	public String toString() {
		return "Calendrier{" +
				"id_calendrier=" + id_calendrier +
				", date_calendrier=" + date_calendrier +
				", utilisateur=" + utilisateur +
				'}';
	}
}

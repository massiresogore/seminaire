package com.warrios.seminaire.modeles;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Evenement {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_evenement;

	@NotNull
	@Size(min = 2, max = 50)
	private String adresse;
	@Size(min=2, max=27)
	private String theme;

	@NotNull
	@Size(min = 2, max = 500)
	private String description_evenement;

	@ManyToMany
			@JoinTable(
					name = "planning",
					joinColumns = @JoinColumn(name = "evenement_id"),
					inverseJoinColumns = @JoinColumn(name = "calendrier_id")
			)
	List<Calendrier> calendrierList = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "utilisateur_id")
	private Utilisateur utilisateur;

	@ManyToMany
			@JoinTable(
					name = "participation",
					joinColumns = @JoinColumn(name = "evenement_id"),
					inverseJoinColumns = @JoinColumn(name = "utilisateur_id")
			)
	List<Utilisateur> utilisateurList = new ArrayList<>();


	@OneToMany(mappedBy = "evenement")
	List<Annonce> annonceList = new ArrayList<>();

	@OneToMany(mappedBy = "evenement")
	List<Notification> notificationList = new ArrayList<>();

}

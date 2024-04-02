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

	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
			@JoinTable(
					name = "planning",
					joinColumns = @JoinColumn(name = "evenement_id"),
					inverseJoinColumns = @JoinColumn(name = "calendrier_id")
			)
	List<Calendrier> calendrierList;

	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "intervenant_id")
	private Utilisateur utilisateur;

	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
			@JoinTable(
					name = "participation",
					joinColumns = @JoinColumn(name = "evenement_id"),
					inverseJoinColumns = @JoinColumn(name = "utilisateur_id")
			)
	List<Utilisateur> utilisateurList;


	@OneToMany(fetch =FetchType.EAGER, mappedBy = "evenement", cascade = CascadeType.ALL)
	List<Annonce> annonceList;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "evenement", cascade = CascadeType.ALL)
	List<Notification> notificationList;

	public Evenement(String adresse, String theme, String description_evenement) {
		this.adresse = adresse;
		this.theme = theme;
		this.description_evenement = description_evenement;
	}

	/*Ajout notification*/
	public void addNotification(Notification notification)
	{
		if(notificationList== null){
			notificationList = new ArrayList<>();
		}
		notification.setEvenement(this);
		notificationList.add(notification);
	}

	/*Ajout Annonce*/
	public void addAnnonce(Annonce annonce)
	{
		if(annonceList== null){
			annonceList = new ArrayList<>();
		}
		annonce.setEvenement(this);
		annonceList.add(annonce);
	}

	/*Ajout Utilisateur*/
	public void addUtilisateur(Utilisateur utilisateur)
	{
		if(utilisateurList== null){
			utilisateurList = new ArrayList<>();
		}
		utilisateur.addEvenement(this);
		utilisateurList.add(utilisateur);
	}

	/*Ajout Calendrier*/
	public void addCalendrier(Calendrier calendrier){
		if (calendrierList==null){
			calendrierList = new ArrayList<>();
		}

		calendrierList.add(calendrier);
	}

	@Override
	public String toString() {
		return "Evenement{" +
				"id_evenement=" + id_evenement +
				", adresse='" + adresse + '\'' +
				", theme='" + theme + '\'' +
				", description_evenement='" + description_evenement + '\'' +
				'}';
	}
}

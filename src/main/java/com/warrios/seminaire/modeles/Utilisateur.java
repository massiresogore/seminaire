package com.warrios.seminaire.modeles;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_user;

    @NotNull
    @Size(min = 2, max = 14)
    private String nom;

    @NotNull
    @Size(min = 2, max = 14)
    private String prenom;

    @NotNull
    @Size(min = 2, max = 14)
    private String affectation;

    @NotNull
    @Size(min = 2, max = 14)
    private String url;

    @NotNull
    @Size(min = 2, max = 14)
    private String login;

    @NotNull
    @Size(min = 2, max = 14)
    private String mdp;

    @NotNull
    @Size(min = 2, max = 14)
    private String email;

    @NotNull
    @Size(min = 2, max = 14)
    private String telephone;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    List<Calendrier> calendrierList;//ok

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    List<Evenement> evenementList;//ok

    @ManyToMany
            @JoinTable(
                    name = "participation",
                    joinColumns = @JoinColumn(name = "utilisateur_id"),
                    inverseJoinColumns = @JoinColumn(name = "evenement_id")
            )
    List<Evenement> evenement_participant_list;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL )
    List<Annonce> annonceList;//ok

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "utilisateur", cascade = CascadeType.ALL)
    List<Commentaire> commentaireList;//ok

    //Utilisateur sans id, l'ors de la création d'un utilisateur
    public Utilisateur(String nom, String prenom, String affectation, String url, String login, String mdp, String email, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.affectation = affectation;
        this.url = url;
        this.login = login;
        this.mdp = mdp;
        this.email = email;
        this.telephone = telephone;
    }

    /*Ajout commentaire*/
    public void addCommentaire(Commentaire commentaire){
        if(commentaireList==null){
            commentaireList = new ArrayList<>();
        }

        commentaire.setUtilisateur(this);
        commentaireList.add(commentaire);
    }

    /*Ajout Annonce*/
    public void addAnnonce(Annonce annonce){
        if(annonceList==null){
            annonceList = new ArrayList<>();
        }

        annonce.setUtilisateur(this);
        annonceList.add(annonce);
    }

    /*Ajout Evenement*/
    public void addEvenement(Evenement evenement){
        if(evenementList==null){
            evenementList = new ArrayList<>();
        }

        evenement.setUtilisateur(this);
        evenementList.add(evenement);
    }

    /*Ajout Evenement de participant*/
    public void addEvenementParticipant(Evenement evenement){
        if(evenement_participant_list==null){
            evenement_participant_list = new ArrayList<>();
        }

        evenement.setUtilisateur(this);
        evenement_participant_list.add(evenement);
    }

    /*Ajout Calendrier*/
    public void addCalendrier(Calendrier calendrier){
        if(calendrierList==null){
            calendrierList = new ArrayList<>();
        }

        calendrier.setUtilisateur(this);
        calendrierList.add(calendrier);
    }




    @Override
    public String toString() {
        return "Utilisateur{" +
                "id_user=" + id_user +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", affectation='" + affectation + '\'' +
                ", url='" + url + '\'' +
                ", login='" + login + '\'' +
                ", mdp='" + mdp + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}

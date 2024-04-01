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

  /*  @OneToMany(mappedBy = "utilisateur")
    List<Calendrier> calendrierList = new ArrayList<>();

    @OneToMany(mappedBy = "utilisateur")
    List<Evenement> evenementList = new ArrayList<>();

    @ManyToMany
            @JoinTable(
                    name = "participation",
                    joinColumns = @JoinColumn(name = "utilisateur_id"),
                    inverseJoinColumns = @JoinColumn(name = "evenement_id")
            )
    List<Evenement> evenement_participant_list = new ArrayList<>();

    @OneToMany(mappedBy = "utilisateur" )
    List<Annonce> annonceList = getAnnonceList();
    */

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "utilisateur", cascade = CascadeType.ALL)
    List<Commentaire> commentaireList;
//    List<Commentaire> commentaireList = new ArrayList<>();

    public void addCommentaire(Commentaire commentaire){
        if(commentaireList==null){
            commentaireList = new ArrayList<>();
        }

        commentaireList.add(commentaire);
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

package com.warrios.seminaire.modeles;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_commentaire;

    @NotNull
    private LocalDate date_commentaire = LocalDate.now();

    @NotNull
    @Size(min = 5, max = 500)
    private String contenu;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    public Commentaire(String contenu, Utilisateur utilisateur) {
        this.contenu = contenu;
        this.utilisateur = utilisateur;
    }


}

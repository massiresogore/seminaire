package com.warrios.seminaire.modeles;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate date;

    @NotNull
    @Size(min = 2, max = 100)
    private String titre;

    @NotNull
    @Size(min = 2, max = 100)
    private String lieu;

    private LocalDate date_update;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "utilisateur_id" )
    private Utilisateur utilisateur;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "evenement_id")
    private Evenement evenement;

    public Annonce(LocalDate date, String titre, String lieu) {
        this.date = date;
        this.titre = titre;
        this.lieu = lieu;
    }
}

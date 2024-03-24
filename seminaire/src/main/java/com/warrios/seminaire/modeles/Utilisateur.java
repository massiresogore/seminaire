package com.warrios.seminaire.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

}

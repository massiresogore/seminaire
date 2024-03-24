package com.warrios.seminaire.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@Entity

public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date date;
    private String titre;
    @Column( length = 30 )
    private String lieu;
    private Date date_update;


    public Annonce() {
    }

    public Annonce(Date date, String titre, String lieu, Date date_update) {
        this.date = date;
        this.titre = titre;
        this.lieu = lieu;
        this.date_update = date_update;
    }

    @Override
    public String toString() {
        return "Annonce{" +
                "id=" + id +
                ", date=" + date +
                ", titre='" + titre + '\'' +
                ", lieu='" + lieu + '\'' +
                ", date_update=" + date_update +
                '}';
    }
}

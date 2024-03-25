package com.warrios.seminaire.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_notification;
    
    private String message;
    private LocalDate date_envoi = LocalDate.now();
    private LocalDate date_reception = LocalDate.now();
}

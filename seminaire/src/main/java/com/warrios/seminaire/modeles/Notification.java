package com.warrios.seminaire.modeles;
import java.time.LocalDate;

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
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_notification;
    
    @NotNull
    @Size (min = 10 , max =500)
    private String message;
    private LocalDate date_envoi = LocalDate.now();
    private LocalDate date_reception = LocalDate.now();
    
}
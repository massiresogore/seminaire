package com.warrios.seminaire.modeles;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date date;

    @NotNull
    @Size(min = 2, max = 14)
    private String titre;

    @NotNull
    @Size(min = 2, max = 20)
    private String lieu;

    private Date date_update;

}

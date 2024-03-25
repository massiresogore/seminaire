package com.warrios.seminaire.modeles;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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


}

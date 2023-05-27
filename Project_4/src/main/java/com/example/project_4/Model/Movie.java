package com.example.project_4.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name  must be not null")
    @Size(min = 3, message = "name must be Length more than 2")
    private String name;

    @NotEmpty(message = "genre must be not null")
    @Column(columnDefinition = "varchar(20) not null check (genre='drama' or genre='action' or genre='comedy')")
    private String genre;

    @NotNull(message = "Rating must be not null")
    @Min(value = 1, message = "Rating must be between 1 - 5")
    @Max(value = 5, message = "Rating must be between 1 - 5")
    private Integer rating;

    @NotNull(message = "duration  must be not null")
    @Min(value = 61, message = "duration must be more than 60")
    private Integer duration;

    @NotNull(message = "director Id must not be null")
    private Integer directorid;

}
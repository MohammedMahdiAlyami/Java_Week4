package com.example.hw19.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Blog {

    @Id ///PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "title most be not empty")
    @Column(columnDefinition = "varchar(50) not null")
    private String title;

    @NotEmpty(message = "category most be not empty")
    @Column(columnDefinition = "varchar(50) not null check (category='health' or category='education' or category='programming')")
    private String category;

    @Size(max = 300)
    @NotEmpty(message = "body most be not empty")
    @Column(columnDefinition = "varchar(300) not null")
    private String body;

    @AssertFalse
    @Column
    private boolean isPublished;

}
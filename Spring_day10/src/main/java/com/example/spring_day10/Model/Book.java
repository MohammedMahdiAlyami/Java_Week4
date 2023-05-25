package com.example.spring_day10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "title most be not empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String title;

    @Column(columnDefinition = "varchar(20) not null")
    @NotEmpty(message = "Author most be not empty")
    private String author;

    @NotEmpty(message = " category most be not empty")
    @Column(columnDefinition = "varchar(20) not null check (category='Academic' or category='Mystery' or category='Novel')")
    private String category;

    @NotNull(message = "isbn most be not empty")
    private Integer isbn;

    @Min(value = 50, message = "numberOfPages most be more than 50")
    private Integer numberOfPages;

}
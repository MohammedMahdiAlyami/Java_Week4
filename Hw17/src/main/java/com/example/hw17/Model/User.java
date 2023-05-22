package com.example.hw17.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name can not be Empty")
    @Column(columnDefinition = "varchar(20) not null")
    @Size(min = 5,message = "name must to be 5 character long")
    private String name;

    @NotEmpty(message = "username can not be Empty")
    @Column(columnDefinition = "varchar(20) unique")
    @Size(min = 5,message = "username must to be 5 character long")
    private String username;

    @NotEmpty(message = "password can not be Empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String password;

    @NotEmpty(message = "email can not be Empty")
    @Email(message = "must be vaild email")
    @Column(columnDefinition = "varchar(20)not null unique")
    private String email;

    @NotEmpty(message = "role can not be Empty")
    @Column(columnDefinition = "varchar(20) not null check ( role='user' or role='admin')")
    private String role;

    @NotNull(message = "age can not be Null")
    private Integer age;
}

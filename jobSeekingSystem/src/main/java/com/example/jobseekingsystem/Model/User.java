package com.example.jobseekingsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    //ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //NAME
    @NotEmpty(message = "Error: Sorry, name can not be empty")
    @Size(min = 5, message = "Error: Sorry, name should contain at least 4 characters")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Error: Sorry, name must contain only characters without numbers")
    @Column(columnDefinition = "varchar(15) not null")
    private String name;


    //EMAIL
    @NotEmpty(message = "Error: Sorry email can not be empty")
    @Email(message = "Error: Sorry, email must be in a valid format")
    @Column(columnDefinition = "varchar(30) unique not null")
    private String email;


    //PASSWORD
    @NotEmpty(message = "Error: Sorry password can not be empty")
    @Column(columnDefinition = "varchar(30) unique not null")
    private String password;


    //AGE
    @NotNull(message = "Error: Sorry age can not be empty")
    @Min(value = 21, message = "Error: Sorry, age must be a number and greater than 21")
    @Column(columnDefinition = "int not null check (age >= 21)")
    private Integer age;




    //ROLE
    @NotEmpty(message = "Error: Sorry role can not be empty")
    @Pattern(regexp = "^(JOB_SEEKER|EMPLOYER)$", message = "Error: Sorry, role must be JOB_SEEKER or EMPLOYER ")
    @Column(columnDefinition = "varchar(20) not null check(role='JOB_SEEKER' or role='EMPLOYER')")
    private String role;


}

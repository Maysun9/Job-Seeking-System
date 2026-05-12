package com.example.jobseekingsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class JobPost {

    //ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //TITLE
    @NotEmpty(message = "Error: Sorry, title can not be empty")
    @Size(min = 5, message = "Error: Sorry, title should contain at least 4 characters")
    @Column(columnDefinition = "varchar(15) not null")
    private String title;

    //DESCRIPTION
    @NotEmpty(message = "Error: Sorry, description can not be empty")
    @Column(columnDefinition = "varchar(100) not null")
    private String description;

    //LOCATION
    @NotEmpty(message = "Error: Sorry, location can not be empty")
    @Column(columnDefinition = "varchar(25) not null")
    private String location;

    //SALARY
    @NotNull(message = "Error: Sorry, salary can not be null")
    @PositiveOrZero(message = "Error: Sorry, salary must be a positive number only")
    @Column(columnDefinition = "double not null check(salary >= 0)")
    private double salary;

    //POSTING DATE
    @NotNull(message = "Error: Sorry, posting date can not be null")
    @Column(columnDefinition = "date not null")
    private LocalDate postingDate;
}

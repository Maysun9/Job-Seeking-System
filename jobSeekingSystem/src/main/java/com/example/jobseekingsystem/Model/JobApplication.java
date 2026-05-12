package com.example.jobseekingsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class JobApplication {
    //ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //USER ID
    @NotNull(message = "Error: Sorry,user id can not be null")
    @Column(columnDefinition = "int not null")
    private Integer userId;

    //JOB POST ID
    @NotNull(message = "Error: Sorry, job post id can not be null")
    @Column(columnDefinition = "int not null")
    private Integer jobPostId;
}

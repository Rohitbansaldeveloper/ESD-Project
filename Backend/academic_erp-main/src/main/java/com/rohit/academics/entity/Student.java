package com.rohit.academics.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int studentId;

    @Column(name = "roll_number")
    private String rollNumber;

    @Column(name = "first_name" )
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "photograph_path")
    private String photographPath;

    @Column(name = "cgpa")
    private float cgpa;

    @Column(name = "total_credits")
    private int totalCredits;

    @Column(name = "graduation_year")
    private String graduationYear;

    @Column(name = "domain")
    private int domain;

    @Column(name = "specialisation")
    private int specialisation;

    @Column(name = "placement_id")
    private int placementId;
}

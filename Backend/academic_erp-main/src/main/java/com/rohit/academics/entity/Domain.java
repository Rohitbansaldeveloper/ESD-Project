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
@Table(name = "domains")
public class Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "domain_id")
    private int domain_id;

    @Column(name = "program")
    private String program;

    @Column(name = "capacity" )
    private int capacity;

    @Column(name = "qualification")
    private String qualification;

    @Column(name = "batch")
    private String batch;

}

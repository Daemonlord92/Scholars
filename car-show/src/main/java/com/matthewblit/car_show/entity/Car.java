package com.matthewblit.car_show.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true, nullable = false)
    private String serial;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private String make;
    @Column(nullable = false)
    private Integer year;
}

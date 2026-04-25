package com.third.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PRODUCT") // Explicitly naming for Oracle
@Data // Generates Getters, Setters, toString, and equals
@NoArgsConstructor // Required by Hibernate
@AllArgsConstructor
public class Product {

    @Id
    @SequenceGenerator(
        name = "product_seq_gen", 
        sequenceName = "PRODUCT_SEQ", 
        allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq_gen")
    private Long id;

    private String name;
    private String description;
    private double price;
    private int quantity;
    private String category;
}
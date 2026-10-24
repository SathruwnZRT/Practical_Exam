package com.example.pos.entity.loyalty_customer;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="loyalty_customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class loyalty_customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customer_id;

    @Column(name="mobile_number",nullable = false)
    private Integer mobile_number;

    @Column(name="full_name",nullable = false)
    private String full_name;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "loyalty_point",nullable = false)
    private Double loyalty_point;

    @Column(name = "registered_at",nullable = false,updatable = false)
    private Date registered_at;

}

package com.example.pos.entity.product;

import jakarta.persistence.*;
import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;

    @Column(nullable = false,unique = true,length = 30)
    private String code;

    @Column(nullable = false,length = 100)
    private String name;

    @Column(name="unit_price" ,nullable = false,updatable = false)
    private Double unit_price;

    @Column(name="available_quantity",nullable = false,length = 30)
    private Integer available_quantity;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,length = 20)
    private Category category;

    @Column(name = "product_id",nullable = false)
    @ManyToOne(fetch=FetchType.LAZY)
    private Product product;

}

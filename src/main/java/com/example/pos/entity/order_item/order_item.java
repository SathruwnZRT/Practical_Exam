package com.example.pos.entity.order_item;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="order_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class order_item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer order_item_id;

    @Column(name="order",nullable = false,updatable = false)
    private Integer order;

    @Column(name = "product_id",nullable = false)
    private String product;

    @Column(name = "quantity",nullable = false)
    private Integer quantity;

    @Column(name = "unit_price",nullable = false)
    private Double unit_price;

    @Column(name = "subtotal",nullable = false,updatable = false)
    private Double subtotal;

}

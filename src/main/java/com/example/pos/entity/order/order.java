package com.example.pos.entity.order;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;

    @Column(name="customer",nullable = false)
    private String customer;

    @Column(name = "order_date_time",nullable = false)
    private Date order_date_time;

    @Column(name="order_status",nullable = false)
    private String order_status;

    @Column(name="loyalty_point",nullable = false)
    private Integer loyalty_point;

}

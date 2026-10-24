package com.example.pos.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Schema
public class orderResponse {
    public orderResponse(Long order_id, String customer, Date order_date_time,String order_status,Integer loyalty_point){
        this.order_id=order_id;
        this.customer=customer;
        this.order_date_time=order_date_time;
        this.order_status=order_status;
        this.loyalty_point=loyalty_point;
    }
    @Schema(
            description = "Unique identifier",
            example = "1",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long order_id;
    @Schema(
            description = "Name of customer",
            example = "customer name"
    )
    private String customer;
    private Date order_date_time;
    @Schema(
            description = "Successfull of order",
            example = "yes"
    )
    private String order_status;
    private Integer loyalty_point;
}

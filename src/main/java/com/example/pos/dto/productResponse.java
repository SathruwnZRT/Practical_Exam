package com.example.pos.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jdk.jfr.Category;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Schema
public class productResponse {
    public productResponse(Long product_id,String code,String name){
        this.product_id=product_id;
        this.code=code;
        this.name=name;

    }
    public productResponse(Double unit_price, Integer available_quantity){
        this.unit_price=unit_price;
        this.available_quantity=available_quantity;
    }

    @Schema(
            description = "Unique identifier",
            example = "1",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long product_id;
    private String code;

    @Schema(
            description = "Name of the product",
            example="product name"
    )
    private String name;
    @Schema(
            description = "one unit price of product",
            example = "one unit price"
    )
    private Double unit_price;
    @Schema(
            description = "available quantity of product",
            example = "25"
    )
    private Integer available_quantity;
}

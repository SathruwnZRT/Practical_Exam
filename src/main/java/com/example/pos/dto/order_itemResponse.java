package com.example.pos.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Schema
public class order_itemResponse {
    public order_itemResponse(Integer order_item_id,Integer order,String product){
        this.order_item = order_item;
        this.order = order;
        this.product=product;
    }
    public order_itemResponse(Integer quantity,Double unit_price,Double subtotal){
        this.quantity=quantity;
        this.unit_price=unit_price;
        this.subtotal=subtotal;
    }
    @Schema(
            description = "Number of order item",
            example="1"
            )
    private Integer order_item;

    @Schema(
            description =  "Number of order",
            example = "1"
    )
    private Integer order;
    @Schema(
            description = "Name of product",
            example = "product name"
    )
    private String product;
    @Schema(
            description = "Number of quantity",
            example = "2"
    )
    private Integer quantity;
    @Schema(
            description = "price of one unit",
            example = "200.00"
    )
    private Double unit_price;
    @Schema(description = "Calculated price of all product",
            example = "2600.00"
    )
    private Double subtotal;
}

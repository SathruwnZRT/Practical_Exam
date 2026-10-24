package com.example.pos.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Schema
public class loyalty_customerResponse {
    public loyalty_customerResponse(Long customer_id,Integer mobile_number,String full_name){
        this.customer_id=customer_id;
        this.mobile_number=mobile_number;
        this.full_name=full_name;
    }
    public loyalty_customerResponse(String email, Double loyalty_point, Date registered_at){
        this.email=email;
        this.loyalty_point=loyalty_point;
        this.registered_at=registered_at;
    }

    @Schema(
            description = "Unique identifier",
            example = "1",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long customer_id;
    @Schema(
            description = "generate caret mobile number",
            example = "mobile number"
    )
    private Integer mobile_number;
    @Schema(
            description = "Full name of the category",
            example = "customer name"
    )
    private String full_name;
    @Schema(
            description = "Enter caret email",
            example = "valid email"
    )
    private String email;
    private Double loyalty_point;
    private Date registered_at;
}

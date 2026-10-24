package com.example.pos.dto;

import com.example.pos.entity.TestStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(
        name = "category",
        description = "category resource"
)
public class categoryResponse {

    public categoryResponse(Long category_id,String code,String name) {
        this.category_id = category_id;
        this.code = code;
        this.name = name;
    }

    public categoryResponse(String description, TestStatus status){
        this.description = description;
        this.status=status;
    }
    @Schema(
            description = "Unique identifier",
            example = "1",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long category_id;
    private String code;

    @Schema(
            description = "Name of the category",
            example = "category name"
    )
    @NotBlank
    private String name;
    @Schema(
            description = "Description of the category",
            example = "category description"
    )
    private String description;
    private TestStatus status;

}

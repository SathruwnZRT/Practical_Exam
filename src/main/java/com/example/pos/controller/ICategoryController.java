package com.example.pos.controller;

import com.example.pos.constant.EndpointConstants;
import com.example.pos.constant.MessageConstants;
import com.example.pos.dto.TestResponse;
import com.example.pos.dto.categoryResponse;
import com.example.pos.network.ApiResponseWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(EndpointConstants.V1 + EndpointConstants.TEST)
@Tag(
        name = "Category",
        description = "APIs for managing Test resources"
)

public interface ICategoryController {
    @Operation(
            summary = "Get all Categories",
            description = "Retrieves all available Category resources."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = MessageConstants.CATEGORY_RETRIEVED_SUCCESSFULLY
            )
    })
    @GetMapping
    ResponseEntity<ApiResponseWrapper<List<categoryResponse>>> findAllTests();

    @GetMapping("/{id}")
    ResponseEntity<ApiResponseWrapper<categoryResponse>> findCategory(@PathVariable Long category_id);

    @PostMapping
    ResponseEntity<ApiResponseWrapper<categoryResponse>> createCategory(@Valid @RequestBody categoryResponse request);

    @PutMapping("/{id}")
    ResponseEntity<ApiResponseWrapper<categoryResponse>> updateCategory(
            @PathVariable Long category_id,
            @Valid @RequestBody categoryResponse request
    );

    @DeleteMapping("/{id}")
    ResponseEntity<ApiResponseWrapper<categoryResponse>> deleteCategory(@PathVariable Long category_id);

    @GetMapping("/search")
    ResponseEntity<ApiResponseWrapper<List<categoryResponse>>> searchcategories(
            @RequestParam String category,
            @RequestParam String status
    );
}

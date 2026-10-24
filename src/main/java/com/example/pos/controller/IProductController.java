package com.example.pos.controller;

import com.example.pos.constant.EndpointConstants;
import com.example.pos.constant.MessageConstants;
import com.example.pos.dto.productResponse;
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
        name = "Product",
        description = "APIs for managing Product resources"
)

public interface IProductController {
    @Operation(
            summary = "Get all products",
            description = "Retrieves all available Test resources."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = MessageConstants.PODUCTS_RETRIEVED_SUCCESSFULLY
            )
    })
    @GetMapping
    ResponseEntity<ApiResponseWrapper<List<productResponse>>> findAllProducts();

    @GetMapping("/{id}")
    ResponseEntity<ApiResponseWrapper<productResponse>> findProduct(@PathVariable Long product_id);

    @PostMapping
    ResponseEntity<ApiResponseWrapper<productResponse>> createProduct(@Valid @RequestBody productResponse request);

    @PutMapping("/{id}")
    ResponseEntity<ApiResponseWrapper<productResponse>> updateProduct(
            @PathVariable Long product_id,
            @Valid @RequestBody productResponse request
    );

    @DeleteMapping("/{id}")
    ResponseEntity<ApiResponseWrapper<productResponse>> deleteProduct(@PathVariable Long product_id);

    @GetMapping("/search")
    ResponseEntity<ApiResponseWrapper<List<productResponse>>> searchProducts(
            @RequestParam String category,
            @RequestParam String status
}

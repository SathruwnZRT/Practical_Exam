package com.example.pos.controller;

import com.example.pos.dto.TestResponse;
import com.example.pos.dto.productResponse;
import com.example.pos.network.ApiResponseWrapper;
import com.example.pos.network.NetworkUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class productController implements IPoductController{
    @Autowired
    private IProductController productService;

    @Override
    public ResponseEntity<ApiResponseWrapper<List<productResponse>>> findAllProducts() {
        return NetworkUtils.wrap(productService.findAllProducts());
    }

    @Override
    public ResponseEntity<ApiResponseWrapper<productResponse>> findProduct(Long product_id) {
        return NetworkUtils.wrap(productService.findProduct(product_id));
    }

    @Override
    public ResponseEntity<ApiResponseWrapper<TestResponse>> createTest(productResponse request) {
        return NetworkUtils.wrap(productService.createProduct(request));
    }

    @Override
    public ResponseEntity<ApiResponseWrapper<productResponse>> updateProduct(Long product_id, TestResponse request) {
        return NetworkUtils.wrap(productService.updateProduct(product_id, request));
    }

    @Override
    public ResponseEntity<ApiResponseWrapper<productResponse>> deleteProduct(Long product_id) {
        return NetworkUtils.wrap(productService.deleteProduct(product_id));
    }

    @Override
    public ResponseEntity<ApiResponseWrapper<List<TestResponse>>> searchProducts(String category, String status) {
        return NetworkUtils.wrap(productService.searchProduct(category, status));
    }
}

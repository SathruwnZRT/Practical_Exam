package com.example.pos.controller;

import com.example.pos.dto.TestResponse;
import com.example.pos.network.ApiResponseWrapper;
import com.example.pos.network.NetworkUtils;
import com.example.pos.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class categoryController implements ICategoryController{
    @Autowired
    private ITestService categoryService;

    @Override
    public ResponseEntity<ApiResponseWrapper<List<categoryResponse>>> findAllCategorys() {
        return NetworkUtils.wrap(categoryService.findAllCategorys());
    }

    @Override
    public ResponseEntity<ApiResponseWrapper<categoryResponse>> finCategory(Long category_id) {
        return NetworkUtils.wrap(categoryService.findTest(category_id));
    }

    @Override
    public ResponseEntity<ApiResponseWrapper<categoryResponse>> createCategory(categoryResponse request) {
        return NetworkUtils.wrap(categoryService.createCategory(request));
    }

    @Override
    public ResponseEntity<ApiResponseWrapper<categoryResponse>> updateCategory(Long category_id, categoryResponse request) {
        return NetworkUtils.wrap(categoryService.updateCategory(category_id, request));
    }

    @Override
    public ResponseEntity<ApiResponseWrapper<categoryResponse>> deleteCategory(Long category_id) {
        return NetworkUtils.wrap(categoryService.deleteCategory(category_id));
    }

    @Override
    public ResponseEntity<ApiResponseWrapper<List<categoryResponse>>> searchCategory(String category, String status) {
        return NetworkUtils.wrap(categoryService.searchCategory(category, status));
    }
}



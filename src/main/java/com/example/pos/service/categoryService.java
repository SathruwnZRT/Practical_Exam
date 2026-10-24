package com.example.pos.service;

import com.example.pos.constant.MessageConstants;
import com.example.pos.dto.TestResponse;
import com.example.pos.network.ResponseData;
import com.example.pos.network.ResponseDataPack;
import org.springframework.http.HttpStatus;

public class categoryService implements ICategoryService{

    private final categoryServiceImpl categoryServiceImpl;

    public private final categoryServiceImpl categoryServiceImpl;

    public private final categoryServiceImpl categoryServiceImpl;

    public categoryService(categoryServiceImpl categoryServiceImpl) {
        this.categoryServiceImpl = categoryServiceImpl;
    }

    @Override
    public ResponseDataPack<categoryResponse> findAllTests() {
        try {
            return categoryServiceImpl.findAll();
        } catch (Exception exception) {
            return ResponseDataPack.error(HttpStatus.INTERNAL_SERVER_ERROR, MessageConstants.UNABLE_TO_RETRIEVE_CATEGORIES);
        }
    }


    @Override
    public ResponseDataPack<TestResponse> searchCategory(String category, String status) {
        try {
            return categoryServiceImpl.searchCategory(category, status);
        } catch (Exception exception) {
            return ResponseDataPack.error(HttpStatus.INTERNAL_SERVER_ERROR, MessageConstants.UNABLE_TO_RETRIEVE_CATEGORIES);
        }
    }

    @Override
    public ResponseData<categoryResponse> findCategory(Long category_id) {
        try {
            return categoryServiceImpl.findCategory(category_id);
        } catch (Exception exception) {
            return ResponseData.error(HttpStatus.INTERNAL_SERVER_ERROR, MessageConstants.UNABLE_TO_RETRIEVE_CATEGORY);
        }
    }

    @Override
    public ResponseData<categoryResponse> createCategory(categoryResponse request) {
        try {
            return categoryServiceImpl.createCategory(request);
        } catch (Exception exception) {
            return ResponseData.error(HttpStatus.INTERNAL_SERVER_ERROR, MessageConstants.UNABLE_TO_CREATE_CATEGORY;
        }
    }

    @Override
    public ResponseData<categoryResponse> updateCategory(Long category_id, TestResponse request) {
        try {
            return categoryServiceImpl.updateCategory(category_id, request);
        } catch (Exception exception) {
            return ResponseData.error(HttpStatus.INTERNAL_SERVER_ERROR, MessageConstants.UNABLE_TO_UPDATE_CATEGORY);
        }
    }

    @Override
    public ResponseData<categoryResponse> deleteTest(Long category_id) {
        try {
            return categoryServiceImpl.deleteCategory(category_id);
        } catch (Exception exception) {
            return ResponseData.error(HttpStatus.INTERNAL_SERVER_ERROR, MessageConstants.UNABLE_TO_DELETE_CATEGORY);
        }
    }Service(categoryServiceImpl categoryServiceImpl) {
        this.categoryServiceImpl = categoryServiceImpl;
    }


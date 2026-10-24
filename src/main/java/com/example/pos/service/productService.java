package com.example.pos.service;

import com.example.pos.constant.MessageConstants;
import com.example.pos.dto.TestResponse;
import com.example.pos.network.ResponseData;
import com.example.pos.network.ResponseDataPack;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class productService {
    private final productServiceImpl productServiceImpl;

    public productService(ProductServiceImpl productServiceImpl) {
        this.productServiceImpl = productServiceImpl;
    }

    @Override
    public ResponseDataPack<productResponse> findAllTests() {
        try {
            return productServiceImpl.findAll();
        } catch (Exception exception) {
            return ResponseDataPack.error(HttpStatus.INTERNAL_SERVER_ERROR, MessageConstants.UNABLE_TO_RETRIEVE_PRODUCT);
        }
    }


    @Override
    public ResponseDataPack<productResponse> searchTest(String category, String status) {
        try {
            return productServiceImpl.searchproduct(category, status);
        } catch (Exception exception) {
            return ResponseDataPack.error(HttpStatus.INTERNAL_SERVER_ERROR, MessageConstants.UNABLE_TO_RETRIEVE_PRODUCT);
        }
    }

    @Override
    public ResponseData<productResponse> findProduct(Long product_id) {
        try {
            return productServiceImpl.findProduct(product_id);
        } catch (Exception exception) {
            return ResponseData.error(HttpStatus.INTERNAL_SERVER_ERROR, MessageConstants.UNABLE_TO_RETRIEVE_PRODUCT);
        }
    }

    @Override
    public ResponseData<productResponse> createProduct(productResponse request) {
        try {
            return testServiceImpl.createTest(request);
        } catch (Exception exception) {
            return ResponseData.error(HttpStatus.INTERNAL_SERVER_ERROR, MessageConstants.UNABLE_TO_CREATE_PRODUCT);
        }
    }

    @Override
    public ResponseData<productResponse> updateProduct(Long product_id, productResponse request) {
        try {
            return productServiceImpl.updateproduct(product_id, request);
        } catch (Exception exception) {
            return ResponseData.error(HttpStatus.INTERNAL_SERVER_ERROR, MessageConstants.UNABLE_TO_UPDATE_PRODUCT);
        }
    }

    @Override
    public ResponseData<productResponse> deleteProduct(Long product_id) {
        try {
            return productServiceImpl.deleteProduct(product_id);
        } catch (Exception exception) {
            return ResponseData.error(HttpStatus.INTERNAL_SERVER_ERROR, MessageConstants.UNABLE_TO_DELETE_PRODUCT);
        }
    }
}

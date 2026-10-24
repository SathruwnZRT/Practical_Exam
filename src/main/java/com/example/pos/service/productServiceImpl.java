package com.example.pos.service;

import com.example.pos.constant.MessageConstants;
import com.example.pos.dto.TestResponse;
import com.example.pos.entity.Test;
import com.example.pos.mapper.TestMapper;
import com.example.pos.network.ResponseData;
import com.example.pos.network.ResponseDataPack;
import com.example.pos.repository.ITestRepository;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;

import java.util.List;

@Schema
@Transactional
public class productServiceImpl {
    private final ITestRepository testRepository;
    private final TestMapper testMapper;

    public productServiceImpl(IProductRepository productRepository, productMapper tproductMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public ResponseDataPack<productResponse> findAll() {
        List<productResponse> tests = productRepository.findAll().stream()
                .map(productMapper::toDto)
                .toList();
        return ResponseDataPack.success(products, MessageConstants.PRODUCTS_SEARCHED_SUCCESSFULLY);
    }


    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public ResponseDataPack<TestResponse> searchProduct(String category, String status) {
        List<TestResponse> tests = testRepository.searchTest(category, status).stream()
                .map(testMapper::toDto)
                .toList();
        return ResponseDataPack.success(tests, MessageConstants.PRODUCTS_RETRIEVED_SUCCESSFULLY);
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public ResponseData<productResponse> find_product(Long product_id) {
        return testRepository.findById(product_id)
                .map(product -> ResponseData.success(testMapper.toDto(product), MessageConstants.PRODUCT_RETRIEVED_SUCCESSFULLY))
                .orElseGet(() -> ResponseData.error(HttpStatus.NOT_FOUND, MessageConstants.PRODUCT_NOT_FOUND));
    }

    public ResponseData<productResponse> createProduct(productResponse request) {
        Test product = productMapper.toDao(request);
        return ResponseData.created(productMapper.toDto(productRepository.save(product)), MessageConstants.PRODUCT_CREATED_SUCCESSFULLY);
    }

    public ResponseData<productResponse> updateProduct(Long product_id, TestResponse request) {
        return testRepository.findById(product_id)
                .map(product -> {
                    productMapper.updateDao(request, product);
                    return ResponseData.success(productMapper.toDto(productRepository.save(product)), MessageConstants.PRODUCT_UPDATED_SUCCESSFULLY);
                })
                .orElseGet(() -> ResponseData.error(HttpStatus.NOT_FOUND, MessageConstants.PRODUCT_NOT_FOUND));
    }

    public ResponseData<productResponse> deleteProduct(Long product_id) {
        return testRepository.findById(product_id)
                .map(product -> {
                    productResponse response = productMapper.toDto(product);
                    productRepository.delete(product);
                    return ResponseData.success(response, MessageConstants.PRODUCT_DELETED_SUCCESSFULLY);
                })
                .orElseGet(() -> ResponseData.error(HttpStatus.NOT_FOUND, MessageConstants.PRODUCT_NOT_FOUND));
    }
}

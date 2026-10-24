package com.example.pos.service;

import com.example.pos.constant.MessageConstants;
import com.example.pos.dto.TestResponse;
import com.example.pos.entity.Test;
import com.example.pos.mapper.TestMapper;
import com.example.pos.network.ResponseData;
import com.example.pos.network.ResponseDataPack;
import com.example.pos.repository.ITestRepository;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class loyalaty_customerServiceImpl {
    private final ILoyalaty_customerRepository loyalaty_customerRepository;
    private final Loyalaty_customerMapper loyalaty_customerMapper;

    public loyalaty_customerServiceImpl(ILoyalaty_customerRepository loyalaty_customerRepository, loyalaty_customerMapper loyalaty_customerMapper) {
        this.loyalaty_customerRepository = loyalaty_customerRepository;
        this.loyalaty_customerMapper = loyalaty_customerMapper;
    }

    @Transactional(readOnly = true)
    public ResponseDataPack<loyalaty_customerResponse> findAll() {
        List<loyalaty_customerResponse> tests = loyalaty_customerRepository.findAll().stream()
                .map(loyalaty_customerMapper::toDto)
                .toList();
        return ResponseDataPack.success(loyalaty_customers, MessageConstants.LOYALATY_CUSTOMER_SEARCHED_SUCCESSFULLY);
    }


    @Transactional(readOnly = true)
    public ResponseDataPack<loyalaty_customerResponse> searchLoyalaty_customer(String category, String status) {
        List<TestResponse> loyalaty_customers = loyalaty_customerRepository.searchl
        Loyalaty_customer(category, status).stream()
                .map(loyalaty_customerMapper::toDto)
                .toList();
        return ResponseDataPack.success(loyalaty_customers, MessageConstants.LOYALATY_CUSTOMERS_RETRIEVED_SUCCESSFULLY);
    }

    @Transactional(readOnly = true)
    public ResponseData<loyalaty_customerResponse> findLoyalaty_customer(Long loyalaty_customer_id) {
        return loyalaty_customerRepository.findById(loyalaty_customer_id)
                .map(loyalaty_customer -> ResponseData.success(loyalaty_customerMapper.toDto(loyalaty_customer), MessageConstants.LOYALTY_CUSTOMER_RETRIEVED_SUCCESSFULLY))
                .orElseGet(() -> ResponseData.error(HttpStatus.NOT_FOUND, MessageConstants.TEST_NOT_FOUND));
    }

    public ResponseData<loyalaty_customerResponse> createLoyalaty_customer(loyalaty_customerResponse request) {
        Loyalaty_customer loyalaty_customer = loyalaty_customerMapper.toDao(request);
        return ResponseData.created(loyalaty_customerMapper.toDto(loyalaty_customerRepository.save(loyalaty_customer)), MessageConstants.LOYALATY_CUSTOMER_CREATED_SUCCESSFULLY);
    }

    public ResponseData<loyalaty_customerResponse> updateLoyalaty_customer(Long loyalaty_customer_id, loyalaty_customerResponse request) {
        return loyalaty_customerRepository.findById(loyalaty_customer_id)
                .map(loyalaty_customer -> {
                    loyalaty_customerMapper.updateDao(request, loyalaty_customer);
                    return ResponseData.success(loyalaty_customerMapper.toDto(loyalaty_customerRepository.save(loyalaty_customer)), MessageConstants.LOYALATY_CUSTOMER_UPDATED_SUCCESSFULLY);
                })
                .orElseGet(() -> ResponseData.error(HttpStatus.NOT_FOUND, MessageConstants.LOYALTY_CUSTOMER_NOT_FOUND));
    }

    public ResponseData<loyalaty_customerResponse> deleteLoyalaty_customer(Long loyalaty_customer_id) {
        return loyalaty_customerRepository.findById(loyalaty_customer_id)
                .map(loyalaty_customer -> {
                    loyalaty_customerResponse response = loyalaty_customerMapper.toDto(loyalaty_customer);
                    loyalaty_customerRepository.delete(loyalaty_customer);
                    return ResponseData.success(response, MessageConstants.LOYALTY_CUSTOMER_DELETED_SUCCESSFULLY);
                })
                .orElseGet(() -> ResponseData.error(HttpStatus.NOT_FOUND, MessageConstants.LOYALTY_CUSTOMER_NOT_FOUND));
    }
}

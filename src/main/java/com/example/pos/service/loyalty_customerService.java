package com.example.pos.service;

import com.example.pos.constant.MessageConstants;
import com.example.pos.dto.TestResponse;
import com.example.pos.dto.loyalty_customerResponse;
import com.example.pos.network.ResponseData;
import com.example.pos.network.ResponseDataPack;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class loyalty_customerService {
    private final loyalty_customerServiceImpl testServiceImpl;

    public loyalty_customerService(loyalty_customerServiceImpl loyalty_customerServiceImpl) {
        this.loyalty_customerServiceImpl = loyalty_customerServiceImpl;
    }

    @Override
    public ResponseDataPack<loyalty_customerResponse> findAllTests() {
        try {
            return loyalty_customerServiceImpl.findAll();
        } catch (Exception exception) {
            return ResponseDataPack.error(HttpStatus.INTERNAL_SERVER_ERROR, MessageConstants.UNABLE_TO_RETRIEVE_LOYALTY_CUSTOMER);
        }
    }


    @Override
    public ResponseDataPack<loyalty_customerResponse> searchLoyalty_customer(String loyalty_customer, String status) {
        try {
            return loyalty_customerServiceImpl.searchLoyalty_customer(loyalty_customer, status);
        } catch (Exception exception) {
            return ResponseDataPack.error(HttpStatus.INTERNAL_SERVER_ERROR, MessageConstants.UNABLE_TO_RETRIEVE_LOYALTY_CUSTOMER);
        }
    }

    @Override
    public ResponseData<loyalty_customerResponse> findLoyalty_customer(Long loyalty_customer_id) {
        try {
            return testServiceImpl.findLoyalty_customer(loyalty_customer_id);
        } catch (Exception exception) {
            return ResponseData.error(HttpStatus.INTERNAL_SERVER_ERROR, MessageConstants.UNABLE_TO_RETRIEVE_LOYALTY_CUSTOMER);
        }
    }

    @Override
    public ResponseData<loyalty_customerResponse> createLoyalty_customer(loyalty_customerResponse request) {
        try {
            return loyalty_customerServiceImpl.createLoyalty_customer(request);
        } catch (Exception exception) {
            return ResponseData.error(HttpStatus.INTERNAL_SERVER_ERROR, MessageConstants.UNABLE_TO_CREATE_LOYALTY_CUSTOMER);
        }
    }

    @Override
    public ResponseData<loyalty_customerResponse> updateLoyalty_customer(Long loyalty_customer_id, TestResponse request) {
        try {
            return loyalty_customerServiceImpl.updateLoyalty_customer(loyalty_customer_id, request);
        } catch (Exception exception) {
            return ResponseData.error(HttpStatus.INTERNAL_SERVER_ERROR, MessageConstants.UNABLE_TO_UPDATE_LOYALTY_CUSTOMER);
        }
    }

    @Override
    public ResponseData<loyalty_customerResponse> deleteLoyalty_customer(Long loyalty_customer_id) {
        try {
            return loyalty_customerServiceImpl.deleteLoyalty_customer(loyalty_customer_id);
        } catch (Exception exception) {
            return ResponseData.error(HttpStatus.INTERNAL_SERVER_ERROR, MessageConstants.UNABLE_TO_DELETE_LOYALATY_CUSTOMER);
        }
    }
}

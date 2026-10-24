package com.example.pos.service;

import com.example.pos.dto.TestResponse;
import com.example.pos.dto.productResponse;
import com.example.pos.network.ResponseData;
import com.example.pos.network.ResponseDataPack;

public interface IProductService {
    ResponseDataPack<productResponse> findAllProducts();

    ResponseDataPack<productResponse> searchProduct(String category, String status);

    ResponseData<productResponse> findProduct(Long product_id);

    ResponseData<productResponse> createProduct(productResponse request);

    ResponseData<productResponse> updateProduct(Long product_id, productResponse request);

    ResponseData<productResponse> deleteProduct(Long product_id);
}

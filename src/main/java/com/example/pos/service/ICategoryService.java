package com.example.pos.service;

import com.example.pos.dto.TestResponse;
import com.example.pos.dto.categoryResponse;
import com.example.pos.network.ResponseData;
import com.example.pos.network.ResponseDataPack;

public interface ICategoryService {
    ResponseDataPack<categoryResponse> findAllCategory();

    ResponseDataPack<categoryResponse> searchCategory(String category, String status);

    ResponseData<categoryResponse> findCategory(Long category_id);

    ResponseData<categoryResponse> createCategory(categoryResponse request);

    ResponseData<categoryResponse> updateCategory(Long category_id, categoryResponse request);

    ResponseData<categoryResponse> deleteCategory(Long category_id);
}

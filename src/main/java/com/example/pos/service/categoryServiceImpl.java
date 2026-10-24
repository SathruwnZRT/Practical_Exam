package com.example.pos.service;

import com.example.pos.constant.MessageConstants;
import com.example.pos.dto.TestResponse;
import com.example.pos.entity.Test;
import com.example.pos.mapper.TestMapper;
import com.example.pos.network.ResponseData;
import com.example.pos.network.ResponseDataPack;
import com.example.pos.repository.ITestRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class categoryServiceImpl {
    private final ICategoryRepository categoryRepository;
    private final categoryMapper categoryMapper;

    public categoryServiceImpl(ICategoryRepository categoryRepository, categoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Transactional(readOnly = true)
    public ResponseDataPack<TestResponse> findAll() {
        List<categoryResponse> tests = categoryRepository.findAll().stream()
                .map(categoryMapper::toDto)
                .toList();
        return ResponseDataPack.success(categories, MessageConstants.CATEGORY_SEARCHED_SUCCESSFULLY);
    }


    @Transactional(readOnly = true)
    public ResponseDataPack<categoryResponse> searchCategory(String category, String status) {
        List<categoryResponse> tests = categoryRepository.searchTest(category, status).stream()
                .map(categoryMapper::toDto)
                .toList();
        return ResponseDataPack.success(tests, MessageConstants.CATEGORY_RETRIEVED_SUCCESSFULLY);
    }

    @Transactional(readOnly = true)
    public ResponseData<categoryResponse> findCategory(Long id) {
        return categoryRepository.findById(id)
                .map(test -> ResponseData.success(categoryMapper.toDto(test), MessageConstants.CATEGORY_RETRIEVED_SUCCESSFULLY))
                .orElseGet(() -> ResponseData.error(HttpStatus.NOT_FOUND, MessageConstants.CATEGORY_NOT_FOUND));
    }

    public ResponseData<categoryResponse> createCategory(categoryResponse request) {
        Category category = categoryMapper.toDao(request);
        return ResponseData.created(categoryMapper.toDto(categoryRepository.save(test)), MessageConstants.CATEGORY_CREATED_SUCCESSFULLY);
    }

    public ResponseData<categoryResponse> updateCategory(Long id, categoryResponse request) {
        return categoryRepository.findById(id)
                .map(test -> {
                    categoryMapper.updateDao(request, category);
                    return ResponseData.success(categoryMapper.toDto(categoryRepository.save(category)), MessageConstants.CATEGORY_UPDATED_SUCCESSFULLY);
                })
                .orElseGet(() -> ResponseData.error(HttpStatus.NOT_FOUND, MessageConstants.TEST_NOT_FOUND));
    }

    public ResponseData<categoryResponse> deleteCategory(Long id) {
        return categoryRepository.findById(id)
                .map(category -> {
                    categoryResponse response = categoryMapper.toDto(category);
                    categoryRepository.delete(category);
                    return ResponseData.success(response, MessageConstants.CATEGORY_DELETED_SUCCESSFULLY);
                })
                .orElseGet(() -> ResponseData.error(HttpStatus.NOT_FOUND, MessageConstants.CATEGORY_NOT_FOUND));
    }
}

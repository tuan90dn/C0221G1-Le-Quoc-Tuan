package com.exercises.model.service.category_service;

import com.exercises.model.entity.Category;
import com.exercises.model.service.IService;

import java.util.List;

public interface ICategoryService extends IService<Category> {
    List<Category> findAllCategory();
}

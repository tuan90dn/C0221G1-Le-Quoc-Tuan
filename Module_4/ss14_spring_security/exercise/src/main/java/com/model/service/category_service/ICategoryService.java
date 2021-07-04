package com.model.service.category_service;



import com.model.entity.Category;
import com.model.service.IService;

import java.util.List;

public interface ICategoryService extends IService<Category> {
    List<Category> findAllCategory();
}

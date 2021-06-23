package com.exercises.model.service.index_service;

import com.exercises.model.entity.Category;
import com.exercises.model.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public Page<Category> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }
    public List<Category> findAllCategory(){
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public Category findById(Integer id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void remove(Integer id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> findByName(String name) {
        return categoryRepository.findIndexByName(name);
    }
}

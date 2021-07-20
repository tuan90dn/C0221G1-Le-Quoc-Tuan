package com.model.service;

import com.model.entity.QuestionType;
import com.model.repository.IQuestionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestionTypeService implements IQuestionTypeService{
    @Autowired
    private IQuestionTypeRepository questionTypeRepository;
    @Override
    public List<QuestionType> findAll() {
        return questionTypeRepository.findAll();
    }

    @Override
    public QuestionType findById(Integer id) {
        return null;
    }

    @Override
    public void save(QuestionType questionType) {

    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public void deleteByFlag(Integer id) {

    }

    @Override
    public Page<QuestionType> findByName(Pageable pageable) {
        return null;
    }
}

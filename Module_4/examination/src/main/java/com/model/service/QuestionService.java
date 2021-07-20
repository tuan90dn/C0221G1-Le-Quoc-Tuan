package com.model.service;

import com.model.entity.Question;
import com.model.repository.IQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService implements IQuestionService {
    @Autowired
    private IQuestionRepository questionRepository;
    @Override
    public List<Question> findAll() {
        return null;
    }

    @Override
    public Question findById(Integer id) {
        return questionRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Question question) {
        questionRepository.save(question);
    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public void deleteByFlag(Integer id) {
        questionRepository.deleteByFlag(id);
    }

    @Override
    public Page<Question> findByName(Pageable pageable) {
        return questionRepository.findQuestionsByName(pageable);
    }

    @Override
    public Page<Question> findQuestionsByTitleContaining(String title,Pageable pageable) {
        return questionRepository.findQuestionsByTitleContaining(title,pageable);
    }

    @Override
    public Page<Question> findQuestionByTitleAndQuestionType(String title, String type, Pageable pageable) {
        return questionRepository.findQuestionByTitleAndQuestionType("%"+title+"%","%"+type+"%",pageable);
    }

    @Override
    public Page<Question> findQuestionsByTitleContainingAndQuestionTypeNameContainingOrderByStatus(String title, String name, Pageable pageable) {
        return questionRepository.findQuestionsByTitleContainingAndQuestionTypeNameContainingOrderByStatus(title,name,pageable);
    }
}

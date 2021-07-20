package com.model.service;

import com.model.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IQuestionService extends IService<Question>{
    Page<Question> findQuestionsByTitleContaining(String title, Pageable pageable);

    Page<Question> findQuestionByTitleAndQuestionType(String title,String type,Pageable pageable);

    Page<Question> findQuestionsByTitleContainingAndQuestionTypeNameContainingOrderByStatus(String title,String name,Pageable pageable);
}

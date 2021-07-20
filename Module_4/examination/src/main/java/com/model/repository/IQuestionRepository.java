package com.model.repository;

import com.model.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IQuestionRepository extends PagingAndSortingRepository<Question,Integer> {
    @Query(value = "select * from question where is_active=true ",nativeQuery = true)
    Page<Question> findQuestionsByName(Pageable pageable);

    Page<Question> findQuestionsByTitleContaining(String title,Pageable pageable);

    @Query(value = "select * from question q join question_type qt on q.id_question_type=qt.id where q.title like :title and qt.name like :type order by q.status,q.date_create desc",nativeQuery = true)
    Page<Question> findQuestionByTitleAndQuestionType(@Param("title") String title,@Param("type") String type,Pageable pageable);
    Page<Question> findQuestionsByTitleContainingAndQuestionTypeNameContainingOrderByStatus(String title,String name,Pageable pageable);




    @Modifying
    @Transactional
    @Query(value = "update question set is_active=false where id = :id",nativeQuery = true)
    void deleteByFlag(@Param("id") Integer id);
}

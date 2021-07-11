package com.model.repository;

import com.model.entity.Employee;
import com.model.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface IServiceRepository extends PagingAndSortingRepository<Service,Integer> {
    @Query(value = "select * from service where name like :name and is_active=true ",nativeQuery = true)
    Page<Service> findServicesByName(@Param("name") String name, Pageable pageable);
}

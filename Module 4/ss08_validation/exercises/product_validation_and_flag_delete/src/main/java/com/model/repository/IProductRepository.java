package com.model.repository;

import com.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface IProductRepository extends PagingAndSortingRepository<Product,Integer> {
    @Query(value = "select * from product_table where name like :name",nativeQuery = true)
    Page<Product> findProductByName(@Param("name") String name, Pageable pageable);
}

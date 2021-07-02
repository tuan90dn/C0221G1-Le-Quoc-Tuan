package com.example.test.model.repository;

import com.example.test.model.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface IProvinceRepository extends JpaRepository<Province,Integer> {
}

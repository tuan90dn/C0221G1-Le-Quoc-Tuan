package com.model.repository;

import com.model.entity.Smartphone;
import org.springframework.data.repository.CrudRepository;

public interface ISmartphoneRepository extends CrudRepository<Smartphone,Long> {
}

package com.model.service.implement;

import com.model.entity.EducationDegree;
import com.model.repository.IEducationDegreeRepository;
import com.model.service.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EducationDegreeService implements IEducationDegreeService {
    @Autowired
    private IEducationDegreeRepository educationDegreeRepository;
    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }

    @Override
    public EducationDegree findById(Integer id) {
        return null;
    }

    @Override
    public void save(EducationDegree educationDegree) {

    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public void deleteByFlag(Integer id) {

    }

    @Override
    public Page<EducationDegree> findByName(String name, Pageable pageable) {
        return null;
    }
}

package com.model.service.implement;

import com.model.entity.Position;
import com.model.repository.IPositionRepository;
import com.model.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionService implements IPositionService {
    @Autowired
    private IPositionRepository positionRepository;
    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public Position findById(Integer id) {
        return null;
    }

    @Override
    public void save(Position position) {

    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public void deleteByFlag(Integer id) {

    }

    @Override
    public Page<Position> findByName(String name, Pageable pageable) {
        return null;
    }
}

package com.model.service.implement;

import com.model.entity.AttachService;
import com.model.repository.IAttachServiceRepository;
import com.model.service.IAttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AttachServiceService implements IAttachServiceService {
    @Autowired
    private IAttachServiceRepository attachServiceRepository;
    @Override
    public List<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }

    @Override
    public AttachService findById(Integer id) {
        return null;
    }

    @Override
    public void save(AttachService attachService) {

    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public void deleteByFlag(Integer id) {

    }

    @Override
    public Page<AttachService> findByName(String name, Pageable pageable) {
        return null;
    }
}

package com.model.service.implement;

import com.model.entity.AppUser;
import com.model.repository.AppUserRepository;
import com.model.service.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AppUserService implements IAppUserService {
    @Autowired
    private AppUserRepository appUserRepository;
    @Override
    public List<AppUser> findAll() {
        return appUserRepository.findAll();
    }

    @Override
    public AppUser findById(Integer id) {
        return null;
    }

    @Override
    public void save(AppUser appUser) {

    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public void deleteByFlag(Integer id) {

    }

    @Override
    public Page<AppUser> findByName(String name, Pageable pageable) {
        return null;
    }
}

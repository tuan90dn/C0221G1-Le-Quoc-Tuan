package com.model.service;

import com.model.entity.User;
import com.model.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepository userRepository;
    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}

package com.commerce.eShop.services;


import com.commerce.eShop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import com.commerce.eShop.repository.UserRepository;

import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    @Transactional
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}

package com.commerce.eShop.services;


import com.commerce.eShop.model.Role;
import com.commerce.eShop.model.User;
import com.commerce.eShop.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import com.commerce.eShop.repository.UserRepository;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public User createUser(User user) {
        if (user.getRoles() == null) {
            //Role role = roleRepository.findByName("USER_ROLE").orElse(null);
            //user.setRoles(new HashSet<>(Collections.singletonList(role)));
        }
        return userRepository.save(user);
    }
}

package com.commerce.eShop.controllers;

import com.commerce.eShop.model.Role;
import com.commerce.eShop.model.User;
import com.commerce.eShop.repository.RoleRepository;
import com.commerce.eShop.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;


@RestController()
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public ResponseEntity<?> getUser() throws JsonProcessingException {

        List<User> users = userService.getAllUsers();

        return new ResponseEntity<>(new ObjectMapper().writeValueAsString(users), HttpStatus.OK);

    }

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody String body) throws JsonProcessingException {

        User user;

        try {
            user = new ObjectMapper().readValue(body, User.class);

            User createdUser = userService.createUser(user);

            return new ResponseEntity<>(new ObjectMapper().writeValueAsString(createdUser), HttpStatus.CREATED);

        } catch (UnrecognizedPropertyException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

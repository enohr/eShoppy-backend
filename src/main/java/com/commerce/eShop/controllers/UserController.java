package com.commerce.eShop.controllers;

import com.commerce.eShop.model.User;
import com.commerce.eShop.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController()
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public ResponseEntity<?> getUser() throws JsonProcessingException {

        List<User> users = userService.getAllUsers();

        return new ResponseEntity<>(new ObjectMapper().writeValueAsString(users), HttpStatus.OK);

    }
}

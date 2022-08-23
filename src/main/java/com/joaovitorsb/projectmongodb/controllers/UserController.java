package com.joaovitorsb.projectmongodb.controllers;

import com.joaovitorsb.projectmongodb.models.UserModel;
import com.joaovitorsb.projectmongodb.services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserModel>> findAll(){
        List<UserModel> list = userService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

}

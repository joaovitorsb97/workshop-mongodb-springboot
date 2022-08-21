package com.joaovitorsb.projectmongodb.controllers;

import com.joaovitorsb.projectmongodb.models.UserModel;
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

    @GetMapping
    public ResponseEntity<List<UserModel>> findAll(){
        UserModel u1 = new UserModel("1", "Maria", "maria@gmail.com");
        UserModel u2 = new UserModel("2", "Alex", "alex@gmail.com");
        UserModel u3 = new UserModel("3", "Bob", "bob@gmail.com");
        List<UserModel> list = new ArrayList<>();
        list.addAll(Arrays.asList(u1, u2, u3));
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

}

package com.joaovitorsb.projectmongodb.controllers;

import com.joaovitorsb.projectmongodb.dto.UserDTO;
import com.joaovitorsb.projectmongodb.models.PostModel;
import com.joaovitorsb.projectmongodb.models.UserModel;
import com.joaovitorsb.projectmongodb.services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<UserModel> list = userService.findAll();
        List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(listDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        UserModel userModel = userService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new UserDTO(userModel));
    }

    @GetMapping(value = "/{id}/posts")
    public ResponseEntity<List<PostModel>> findPosts(@PathVariable String id){
        UserModel userModel = userService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(userModel.getPosts());
    }
    
    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO userDTO){
        UserModel userModel = userService.fromDTO(userDTO);
        userModel = userService.insert(userModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userModel.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody UserDTO userDTO, @PathVariable String id){
        UserModel userModel = userService.fromDTO(userDTO);
        userModel.setId(id);
        userService.update(userModel);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id){
        userService.deleteById(id);
        return ResponseEntity.noContent().build();

    }




}

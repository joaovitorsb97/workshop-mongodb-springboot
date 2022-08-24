package com.joaovitorsb.projectmongodb.controllers;

import com.joaovitorsb.projectmongodb.models.PostModel;
import com.joaovitorsb.projectmongodb.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostService postService;

  
    @GetMapping(value = "/{id}")
    public ResponseEntity<PostModel> findById(@PathVariable String id){
        PostModel postModel = postService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(postModel);
    }

    
}

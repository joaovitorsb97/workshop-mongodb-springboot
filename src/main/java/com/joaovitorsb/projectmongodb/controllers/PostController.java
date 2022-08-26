package com.joaovitorsb.projectmongodb.controllers;

import com.joaovitorsb.projectmongodb.models.PostModel;
import com.joaovitorsb.projectmongodb.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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
    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<PostModel>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){ //@RequestParam(value = "text") gets after "?" from URL
        text = URL.decodeParam(text);
        List<PostModel> list = postService.findByTitleContainingIgnoreCase(text);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping(value = "/fullsearch")
    public ResponseEntity<List<PostModel>> fullSearch(@RequestParam(value = "text", defaultValue = "") String text,
                                                      @RequestParam(value = "minDate", defaultValue = "") String minDate,
                                                      @RequestParam(value = "maxDate", defaultValue = "") String maxDate){ //@RequestParam(value = "text") gets after "?" from URL
        text = URL.decodeParam(text);
        Date min = URL.convertDate(minDate, new Date(0L));
        Date max = URL.convertDate(maxDate, new Date());
        List<PostModel> list = postService.fullSearch(text, min, max);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }




    
}

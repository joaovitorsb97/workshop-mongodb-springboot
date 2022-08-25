package com.joaovitorsb.projectmongodb.services;

import com.joaovitorsb.projectmongodb.exceptions.ObjectNotFoundException;
import com.joaovitorsb.projectmongodb.models.PostModel;
import com.joaovitorsb.projectmongodb.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public PostModel findById(String id) {
        Optional<PostModel> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(id));
    }

    public List<PostModel> findByTitleContainingIgnoreCase(String text){
        return postRepository.searchTitle(text);
    }

}

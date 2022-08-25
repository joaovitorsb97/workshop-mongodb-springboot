package com.joaovitorsb.projectmongodb.repositories;

import com.joaovitorsb.projectmongodb.models.PostModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<PostModel, String> {

    List<PostModel> findByTitleContainingIgnoreCase(String text); //Used this method from the https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<PostModel> searchTitle(String text);
}

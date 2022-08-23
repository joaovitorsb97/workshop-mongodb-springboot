package com.joaovitorsb.projectmongodb.repositories;

import com.joaovitorsb.projectmongodb.models.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserModel, String> {
}

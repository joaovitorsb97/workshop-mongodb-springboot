package com.joaovitorsb.projectmongodb.services;

import com.joaovitorsb.projectmongodb.models.UserModel;
import com.joaovitorsb.projectmongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserModel> findAll(){
       return userRepository.findAll();
    }
}

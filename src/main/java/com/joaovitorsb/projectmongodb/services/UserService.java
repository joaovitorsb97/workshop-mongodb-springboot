package com.joaovitorsb.projectmongodb.services;

import com.joaovitorsb.projectmongodb.dto.UserDTO;
import com.joaovitorsb.projectmongodb.exceptions.DatabaseException;
import com.joaovitorsb.projectmongodb.exceptions.ObjectNotFoundException;
import com.joaovitorsb.projectmongodb.models.UserModel;
import com.joaovitorsb.projectmongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserModel> findAll(){
       return userRepository.findAll();
    }

    public UserModel findById(String id){
        Optional<UserModel> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(id));
    }
    public UserModel insert(UserModel userModel){
        return userRepository.save(userModel);
    }
    public void deleteById(String id){
        try{
            userRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e) {
            throw new ObjectNotFoundException(id);
        }catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
    public UserModel update(UserModel userModel){
        UserModel newUserModel = findById(userModel.getId());
        updateData(newUserModel, userModel);
        return userRepository.save(newUserModel);
    }
    public void updateData(UserModel newUserModel, UserModel userModel){
        newUserModel.setId(userModel.getId());
        newUserModel.setName(userModel.getName());
        newUserModel.setEmail(userModel.getEmail());
    }
    public UserModel fromDTO(UserDTO userDTO){
        return new UserModel(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}

package com.olp.service;

import com.olp.entity.UserEntity;
import com.olp.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity createUser(UserEntity ue){
        return this.userRepository.save(ue);
    }

    public UserEntity findByEmailAndActiveStatus(String email,String activeStatus){
        return this.userRepository.findByEmailAndActiveStatus(email,activeStatus);
    }

    public UserEntity getUserById(long id){
        return this.userRepository.getUserById(id);
    }
}

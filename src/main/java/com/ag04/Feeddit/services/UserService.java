package com.ag04.Feeddit.services;

import com.ag04.Feeddit.entities.User;
import com.ag04.Feeddit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUser(String username){
        return userRepository.findOne(username);
    }

    public boolean exists(String username) {
        return userRepository.exists(username);
    }
}

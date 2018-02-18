package com.ag04.Feeddit.services;

import com.ag04.Feeddit.entities.LoggedUser;
import com.ag04.Feeddit.repositories.LoggedUserRepository;
import com.ag04.Feeddit.repositories.UserRepository;
import com.ag04.Feeddit.workers.PasswordCoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public boolean isUserExists(String username){
        return userRepository.exists(username);
    }

    public boolean isUserPasswordCorrect(String username, String password) {

        if(!isUserExists(username)) return false;

        String decryptedPassword = PasswordCoder.decode(userRepository.findOne(username).getPassword().replace(" ", ""));
        return decryptedPassword.equals(password);
    }
}

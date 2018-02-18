package com.ag04.Feeddit.services;

import com.ag04.Feeddit.entities.LoggedUser;
import com.ag04.Feeddit.repositories.LoggedUserRepository;
import com.ag04.Feeddit.workers.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggedUsersService {

    @Autowired
    private LoggedUserRepository loggedUserRepository;

    public boolean isLoggedIn(String username, String token){

        return username != null &&
                token != null &&
                loggedUserRepository.exists(username) &&
                loggedUserRepository.findOne(username).getToken().equals(token);
    }

    public boolean isLoggedIn(LoggedUser user){

        return user.getUsername() != null &&
                user.getToken() != null &&
                loggedUserRepository.exists(user.getUsername()) &&
                loggedUserRepository.findOne(user.getUsername()).getToken().equals(user.getToken());
    }

    public LoggedUser loginUser(String username) {


        loggedUserRepository.save(new LoggedUser(username, TokenGenerator.generateToken()));

        return loggedUserRepository.findOne(username);
    }

    public void logoutUser(String username, String token){

        if(isLoggedIn(username, token)){
            loggedUserRepository.delete(username);
        }
    }
}

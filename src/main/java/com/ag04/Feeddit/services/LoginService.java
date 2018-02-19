package com.ag04.Feeddit.services;
import com.ag04.Feeddit.workers.PasswordCoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserService userService;

    public boolean isUserExists(String username){
        return userService.exists(username);
    }

    public boolean isUserPasswordCorrect(String username, String password) {

        if(!isUserExists(username)) return false;

        String decryptedPassword = PasswordCoder.decode(userService.getUser(username).getPassword());
        return decryptedPassword.equals(password);
    }
}

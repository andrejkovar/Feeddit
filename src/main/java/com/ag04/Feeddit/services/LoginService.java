package com.ag04.Feeddit.services;

import com.ag04.Feeddit.entities.Article;
import com.ag04.Feeddit.repositories.ArticleRepository;
import com.ag04.Feeddit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArticleRepository articleRepository;

    public boolean isUserExists(String username){

        return userRepository.exists(username);
    }

    public boolean isUserPasswordCorrect(String username, String password) {

        if(!isUserExists(username)) return false;

        String decryptedPassword = PasswordCoder.decode(userRepository.findOne(username).getPassword().replace(" ", ""));

        return decryptedPassword.equals(password);
    }

    public List<Article> getUserArticles(String username) {
        return articleRepository.findByUserUsername(username);
    }
}

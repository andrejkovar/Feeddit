package com.ag04.Feeddit.entities;

import com.ag04.Feeddit.services.PasswordCoder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    public User(){

    }

    public User(String username, String password) {
        this.username = username;
        this.password = PasswordCoder.encode(password);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

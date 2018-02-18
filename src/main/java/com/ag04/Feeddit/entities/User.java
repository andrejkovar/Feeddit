package com.ag04.Feeddit.entities;

import com.ag04.Feeddit.workers.PasswordCoder;

import javax.persistence.*;

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

package com.ag04.Feeddit.entities;

import javax.persistence.*;

@Entity
@Table(name = "loggedusers")
public class LoggedUser {

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "token")
    private String token;

    public LoggedUser(){

    }

    public LoggedUser(String username, String token) {

        this.username = username;
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

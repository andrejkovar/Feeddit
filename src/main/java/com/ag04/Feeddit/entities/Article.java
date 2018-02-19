package com.ag04.Feeddit.entities;

import javax.persistence.*;

@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "username")
    private User user;

    @Column(name = "votes")
    private int votes;

    @Column(name = "headline")
    private String headline;

    @Column(name = "author")
    private String author;

    @Column(name = "link")
    private String link;

    public Article(){

    }

    public Article(User user, String headline, String author, String link) {
        this.user = user;
        this.headline = headline;
        this.author = author;
        this.link = link;

        votes = 0;
    }

    public int getId(){
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headLine) {
        this.headline = headLine;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}

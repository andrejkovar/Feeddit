package com.ag04.Feeddit.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Article {

    @ManyToOne
    private User user;

    @Column(name = "votes")
    private long votes;

    @Column(name = "headline")
    private String headLine;

    @Column(name = "author")
    private String author;

    @Column(name = "link")
    private String link;

    public Article(User user, String headLine, String author, String link) {
        this.user = user;
        this.headLine = headLine;
        this.author = author;
        this.link = link;

        votes = 0;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getVotes() {
        return votes;
    }

    public void setVotes(long votes) {
        this.votes = votes;
    }

    public String getHeadLine() {
        return headLine;
    }

    public void setHeadLine(String headLine) {
        this.headLine = headLine;
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

package com.ag04.Feeddit.entities;

import javax.persistence.*;

@Entity
@Table(name = "votes")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "username")
    private User user;

    @OneToOne
    @JoinColumn(name = "articleid")
    private Article article;

    @Column(name = "vote")
    private boolean vote;

    public Vote(){

    }

    public Vote(User user, Article article, boolean vote) {
        this.user = user;
        this.article = article;
        this.vote = vote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public boolean getVote() {
        return vote;
    }

    public void setVote(boolean vote) {
        this.vote = vote;
    }
}

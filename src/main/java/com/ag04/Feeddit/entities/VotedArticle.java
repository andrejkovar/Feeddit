package com.ag04.Feeddit.entities;

public class VotedArticle {

    private Article article;

    private boolean votedUp = false;
    private boolean votedDown = false;

    public VotedArticle(){

    }

    public VotedArticle(Article article){
        this.article = article;
    }

    public void setVote(Boolean vote){

        if(vote == null) return;

        if(vote){
            votedUp = true;
            return;
        }
        votedDown = true;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public boolean isVotedUp() {
        return votedUp;
    }

    public void setVotedUp(boolean votedUp) {
        this.votedUp = votedUp;
    }

    public boolean isVotedDown() {
        return votedDown;
    }

    public void setVotedDown(boolean votedDown) {
        this.votedDown = votedDown;
    }
}

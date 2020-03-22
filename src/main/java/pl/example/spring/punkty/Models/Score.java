package pl.example.spring.punkty.Models;

public class Score {
    private int score;
    private String comment;

    public Score() {
    }

    public Score(int score, String comment) {
        this.score = score;
        this.comment = comment;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

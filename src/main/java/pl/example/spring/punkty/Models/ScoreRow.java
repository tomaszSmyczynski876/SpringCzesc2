package pl.example.spring.punkty.Models;

import javax.persistence.*;

@Entity
public class ScoreRow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int score;
    private String comment;
    @ManyToOne
    private StudentROw studentROw;

    public ScoreRow() {
    }

    public ScoreRow(int score, String comment, StudentROw studentROw) {
        this.score = score;
        this.comment = comment;
        this.studentROw = studentROw;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public StudentROw getStudentROw() {
        return studentROw;
    }

    public void setStudentROw(StudentROw studentROw) {
        this.studentROw = studentROw;
    }


}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hdang09.entites;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.UniqueConstraint;
//import org.hibernate.annotations.Entity;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    @Column(name = "studentID")
    private String studentID;
    private int score;
    @Column(name = "time_start")   
    private long timeStart;
    @Column(name = "time_end")   
    private long timeEnd;
    private long time;
//    private Question questions;
    private String questions;
    @Column(name = "my_answers")   
    private String myAnswers;
    private int rank;
    
    public User() {
    }

    public User(String name, String studentID, int score, long timeStart, long timeEnd, long time, String questions, String myAnswers, int rank) {
        this.name = name;
        this.studentID = studentID;
        this.score = score;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.time = time;
        this.questions = questions;
        this.myAnswers = myAnswers;
        this.rank = rank;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public long getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(long timeStart) {
        this.timeStart = timeStart;
    }

    public long getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(long timeEnd) {
        this.timeEnd = timeEnd;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

//    public Question getQuestions() {
//        return questions;
//    }
//
//    public void setQuestions(Question questions) {
//        this.questions = questions;
//    }

    public String getMyAnswers() {
        return myAnswers;
    }

    public void setMyAnswers(String myAnswers) {
        this.myAnswers = myAnswers;
    }
    
    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}

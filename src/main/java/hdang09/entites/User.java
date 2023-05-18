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
//import org.hibernate.annotations.Entity;


@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "_id")
    private String id;
    private String name;
    private String studentID;
    private int score;
    private long timeStart;
    private long timeEnd;
    @Column(name = "time")
    private int time;
//    private Question questions;
    private String questions;
    private List<Integer> myAnswers;
    private int rank;

    public User() {
    }

    public User(String id, String name, String studentID, int score, long timeStart, long timeEnd, int time, String questions, List<Integer> myAnswers, int rank) {
        this.id = id;
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

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
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
    public List<Integer> getMyAnswers() {
        return myAnswers;
    }

    public void setMyAnswers(List<Integer> myAnswers) {
        this.myAnswers = myAnswers;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", studentID=" + studentID + ", score=" + score + ", timeStart=" + timeStart + ", timeEnd=" + timeEnd + ", time=" + time + ", questions=" + questions + ", myAnswers=" + myAnswers + ", rank=" + rank + '}';
    }

}

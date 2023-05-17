/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hdang09.entites;

import java.util.List;

/**
 *
 * @author Admin
 */
public class User {

    private int id;
    private String name;
    private String studentID;
    private int score;
    private int timeStart;
    private int timeEnd;
    private int time;
//    private Question questions;
    private String questions;
    private List<Integer> myAnswers;
    private int rank;

    public User() {
    }

    public User(int id, String name, String studentID, int score, int timeStart, int timeEnd, int time, String questions, List<Integer> myAnswers, int rank) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(int timeStart) {
        this.timeStart = timeStart;
    }

    public int getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(int timeEnd) {
        this.timeEnd = timeEnd;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
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

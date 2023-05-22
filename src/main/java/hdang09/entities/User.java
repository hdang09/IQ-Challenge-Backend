/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hdang09.entities;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String studentID;
    private int score;
    @Column(name = "time_start")
    private long timeStart;
    @Column(name = "time_end")
    private long timeEnd;
    private long time;
    private String questions;
    @Column(name = "my_answers")
    private String myAnswers;
    @Column(name = "ranking")
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

    public List<Integer> getQuestions() {
        List<Integer> questionIds = new ArrayList<>();
        for (String id : questions.split(",")) {
            questionIds.add(Integer.valueOf(id));
        }
        return questionIds;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public List<Integer> getMyAnswers() {
        List<Integer> ans = new ArrayList<>();
        for (String id : myAnswers.split(",")) {
            ans.add(Integer.valueOf(id));
        }
        return ans;
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

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", studentID=" + studentID + ", score=" + score + ", timeStart=" + timeStart + ", timeEnd=" + timeEnd + ", time=" + time + ", questions=" + questions + ", myAnswers=" + myAnswers + ", rank=" + rank + '}';
    }
}

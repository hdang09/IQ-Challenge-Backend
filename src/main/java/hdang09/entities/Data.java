/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hdang09.entities;

import java.util.List;

/**
 *
 * @author Admin
 */
public class Data {

    private List<Question> questions;
    private long timeStart;

    public Data() {
    }

    public Data(List<Question> questions, long timeStart) {
        this.questions = questions;
        this.timeStart = timeStart;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public long getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(long timeStart) {
        this.timeStart = timeStart;
    }

    @Override
    public String toString() {
        return "Data{" + "questions=" + questions + ", timeStart=" + timeStart + '}';
    }

}

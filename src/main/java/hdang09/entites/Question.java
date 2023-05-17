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
public class Question {
    private int id;
    private List<String> question;
    private List<String> multipleChoice;
    private int answer;
    private boolean isLong;

    public Question() {
    }

    public Question(int id, List<String> question, List<String> multipleChoice, int answer, boolean isLong) {
        this.id = id;
        this.question = question;
        this.multipleChoice = multipleChoice;
        this.answer = answer;
        this.isLong = isLong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getQuestion() {
        return question;
    }

    public void setQuestion(List<String> question) {
        this.question = question;
    }

    public List<String> getMultipleChoice() {
        return multipleChoice;
    }

    public void setMultipleChoice(List<String> multipleChoice) {
        this.multipleChoice = multipleChoice;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public boolean isIsLong() {
        return isLong;
    }

    public void setIsLong(boolean isLong) {
        this.isLong = isLong;
    }

    @Override
    public String toString() {
        return "Question{" + "id=" + id + ", question=" + question + ", multipleChoice=" + multipleChoice + ", answer=" + answer + ", isLong=" + isLong + '}';
    }
}

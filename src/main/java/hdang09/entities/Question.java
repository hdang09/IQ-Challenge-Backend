/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hdang09.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<QuestionText> question;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<MultipleChoice> multipleChoice;

    private int answer;

    @Column(name = "is_long")
    private int isLong;

    public Question() {
    }

    public Question(int id, List<QuestionText> question, List<MultipleChoice> multipleChoice, int answer, int isLong) {
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
        List<String> questions = new ArrayList<>();
        for (QuestionText qt : question) {
            questions.add(qt.getText());
        }
        return questions;
    }

    public void setQuestion(List<QuestionText> question) {
        this.question = question;
    }

    public List<String> getMultipleChoice() {
        List<String> choices = new ArrayList<>();
        for (MultipleChoice mc : multipleChoice) {
            choices.add(mc.getChoice());
        }
        return choices;
    }

    public void setMultipleChoice(List<MultipleChoice> multipleChoice) {
        this.multipleChoice = multipleChoice;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int getIsLong() {
        return isLong;
    }

    public void setIsLong(int isLong) {
        this.isLong = isLong;
    }

    @Override
    public String toString() {
        return "Question{" + "id=" + id + ", question=" + question + ", multipleChoice=" + multipleChoice + ", answer=" + answer + ", isLong=" + isLong + '}';
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hdang09.entities;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.apache.commons.codec.digest.DigestUtils;

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

    public Question(int answer, int isLong) {
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
            if (qt.getText().startsWith("src/assets/images")) {
                String[] parts = qt.getText().split("/");
                String lastPart = parts[parts.length - 1];
                String md5Hash = DigestUtils.md5Hex(lastPart);
                questions.add("/images/" + md5Hash + ".png");
                continue;
            }
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

    public boolean getIsLong() {
        return isLong == 1;
    }

    public void setIsLong(int isLong) {
        this.isLong = isLong;
    }

    @Override
    public String toString() {
        return "Question{" + "id=" + id + ", question=" + question + ", multipleChoice=" + multipleChoice + ", answer=" + answer + ", isLong=" + isLong + '}';
    }
}

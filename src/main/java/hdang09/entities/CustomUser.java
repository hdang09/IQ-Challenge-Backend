/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hdang09.entities;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Admin
 */
public class CustomUser {
    private String name;
    private String studentID;
    private List<Integer> answer;

    public CustomUser() {
    }

    public CustomUser(String name, String studentID, List<Integer> answer) {
        this.name = name;
        this.studentID = studentID;
        this.answer = answer;
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

    public List<Integer> getAnswer() {
        return answer;
    }
    
    public String getAnswerString() {
        return answer.stream().map(String::valueOf).collect(Collectors.joining(",")); 

    }

    public void setAnswer(List<Integer> answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "CustomUser{" + "name=" + name + ", studentID=" + studentID + ", answer=" + answer + '}';
    }

    
}

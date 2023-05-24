/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hdang09.entities.data;

import hdang09.entities.User;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ScoreboardData {
    private int studentRank;
    private List<User> users;

    public ScoreboardData() {
    }

    public ScoreboardData(int studentRank, List<User> users) {
        this.studentRank = studentRank;
        this.users = users;
    }

    public int getStudentRank() {
        return studentRank;
    }

    public void setStudentRank(int studentRank) {
        this.studentRank = studentRank;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "ScoreboardData{" + "studentRank=" + studentRank + ", users=" + users + '}';
    }
    
    
}

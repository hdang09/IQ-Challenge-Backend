/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hdang09.services;

import hdang09.entites.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class UserService {

    List<User> users = new ArrayList<>();

    public UserService() {
        List<Integer> answers = new ArrayList<>();
        answers.add(456);
        users.add(new User(1, "name", "studentID", 1123, 231, 123, 3, "questions", answers, 23));
        users.add(new User(2, "name", "studentID", 1123, 231, 123, 3, "questions", answers, 23));
        users.add(new User(3, "name", "studentID", 1123, 231, 123, 3, "questions", answers, 23));
        users.add(new User(4, "name", "studentID", 1123, 231, 123, 3, "questions", answers, 23));
    }

    public List<User> getAllUser() {
        return users;
    }

    public User getUserResult(int studentId) {
        for (User user: users) {
            if (user.getId() == studentId) return user;
        }
        return null;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hdang09.services;

import hdang09.entites.User;
import hdang09.repositories.UserRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */

@Service
public class UserService {

//    static List<Integer> answers = new ArrayList<>(Arrays.asList(456, 654, 78, 56));
//
//    static List<User> users = new ArrayList<>(
//            Arrays.asList(
//                    new User("1", "name", "studentID", 1123, 231, 123, 3, "questions", "answers", 23),
//                    new User("2", "name", "studentID", 1123, 231, 123, 3, "questions", "answers", 23),
//                    new User("3", "name", "studentID", 1123, 231, 123, 3, "questions", "answers", 23),
//                    new User("4", "name", "studentID", 1123, 231, 123, 3, "questions", "answers", 23)
//            )
//    );
    
    @Autowired
    private UserRepository repository;

    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        for (User user: repository.findAll()) {
            users.add(user);
        }
        return users;
    }

//    public User getUserResult(int studentId) {
//        for (User user : users) {
//            if (user.getId() == studentId) {
//                return user;
//            }
//        }
//        return null;
//    }
//
//    public void register(User user) {
//        users.add(user);
//    }
//
//    public String updateUser(User updateduser, int studentId) {
//        String result = "";
//        
//        for (int i = 0; i < users.size(); i++) {
//            if (users.get(i).getId() == studentId) {
//                updateduser.setId(studentId);
//                users.set(i, updateduser);
//                result = "Updated";
//            }
//        }
//        return result.isEmpty() ? "Can't find studentId" : result;
//    }
//    
//    public String deleteUser(int studentId) {
//        String result = "";
//        
//        for (int i = 0; i < users.size(); i++) {
//            if (users.get(i).getId() == studentId) {
//                users.remove(i);
//                result = "Deleted";
//            }
//        }
//        return result.isEmpty() ? "Can't find studentId" : result;
//    }
}

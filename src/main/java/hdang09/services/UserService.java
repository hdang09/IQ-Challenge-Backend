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
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

/**
 *
 * @author Admin
 */
@Service
public class UserService {

    @Autowired
    private UserRepository repository;
//    private static final Logger logger = LogManager.getLogger(UserService.class);
    

    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        for (User user : repository.findAll()) {
            users.add(user);
        }
        return users;
    }

    public User getUserResult(String studentId) {
        for (User user : repository.findAll()) {
            if (user.getStudentID().equals(studentId)) {
                return user;
            }
        }
//        repository.findById(studentId).get();
        return null;
    }

    public void register(User newUser) {
//        logger.info("StudentID: ", newUser.getStudentID());
        repository.save(newUser);
    }

    public void updateUser(User updatedUser) {
        repository.save(updatedUser);
    }

    public String deleteUser(String studentId) {
        String result = "";
        
        for (User user : repository.findAll()) {
            if (user.getStudentID().equals(studentId)) {
                repository.delete(user);
                result = "Deleted!!!";
            }
        }
        return result.isEmpty() ? "Can't find student ID" : result;
    }
}

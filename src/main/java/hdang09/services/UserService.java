/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hdang09.services;

import hdang09.entites.User;
import hdang09.entities.CustomResponse;
import hdang09.repositories.UserRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        return repository.getAllUsers();
    }

    public User getUserResult(String studentId) {
        return repository.getUserByStudentId(studentId);
    }

    public ResponseEntity<CustomResponse> register(User newUser) {
        User user = repository.getUserByStudentId(newUser.getStudentID());
        CustomResponse response = new CustomResponse();

        if (user == null) {
            repository.save(newUser);
            response = new CustomResponse(true, "Đăng ký thành công!");
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
        }

        if (!user.getName().equals(newUser.getName())) {
            response = new CustomResponse(false, "Họ tên không trùng với MSSV đã đăng ký trước đó!");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        }
        
        if (user.getTimeEnd() != 0) {
            response = new CustomResponse(true, "Đã đăng ký trước đó, đăng nhập thành công!");
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
        }
        
        if (user.getTimeEnd() == 0) {
            response = new CustomResponse(false, "MSSV này đã được sử dụng!");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        }

        response = new CustomResponse(false, "Something went wrong");
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hdang09.services;

import hdang09.entities.User;
import hdang09.entities.CustomResponse;
import hdang09.entities.CustomUser;
import hdang09.entities.Data;
import hdang09.entities.Question;
import hdang09.repositories.QuestionRepository;
import hdang09.repositories.UserRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private QuestionRepository qRepo;

    public List<User> getAllUser() {
        return userRepo.getAllUsers();
    }

    public User getUserResult(String studentId) {
        return userRepo.getUserByStudentId(studentId);
    }

    public ResponseEntity<CustomResponse> register(User newUser) {
        User user = userRepo.getUserByStudentId(newUser.getStudentID());
        CustomResponse response = new CustomResponse();

        if (user == null) {
            newUser.setName(newUser.getName().toUpperCase());
            newUser.setStudentID(newUser.getStudentID().toUpperCase());
            userRepo.save(newUser);
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
        userRepo.save(updatedUser);
    }

    public void deleteUser(String studentId) {
        User userDb = userRepo.getUserByStudentId(studentId);
        userRepo.delete(userDb);
    }

    public ResponseEntity<CustomResponse> startTheQuiz(String studentID) {
        User userDb = userRepo.getUserByStudentId(studentID.toUpperCase());

        if (userDb == null) {
            CustomResponse response = new CustomResponse(false, "Không tìm thấy user!");
            return ResponseEntity.status(400).body(response);
        }

        if (userDb.getTimeEnd() != 0) {
            CustomResponse response = new CustomResponse(false, "Bạn đã nộp bài trước đó!");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        }

        if (userDb.getTimeStart() != 0) {
            List<Integer> questionIds = userDb.getQuestions();
            List<Question> questions = new ArrayList<>();
            for (int id : questionIds) {
                questions.add(qRepo.findById(id).get());
            }
            CustomResponse response = new CustomResponse(true, "Lấy dữ liệu thành công!", new Data(questions, userDb.getTimeStart()));
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
        }

        // Get random 15 questions
        List<Question> questionsDb = new ArrayList<>();
        for (Question q : qRepo.findAll()) {
            questionsDb.add(q);
        }

        if (questionsDb.size() < 15) {
            CustomResponse response = new CustomResponse(false, "Số câu hỏi không đủ để bắt đầu bài thi!");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        Collections.shuffle(questionsDb);
        List<Question> randomQuestions = questionsDb.subList(0, 15);

        String questionIds = "";
        for (Question q : randomQuestions) {
            questionIds = questionIds + q.getId() + ",";
        }
        questionIds = questionIds.substring(0, questionIds.length() - 1);

        userDb.setQuestions(questionIds);
        userDb.setTimeStart(System.currentTimeMillis());
        userRepo.save(userDb);

        CustomResponse response = new CustomResponse(true, "Lấy dữ liệu thành công!", new Data(randomQuestions, userDb.getTimeStart()));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    public ResponseEntity<CustomResponse> submitTheQuiz(CustomUser user) {
        User userDb = userRepo.getUserByStudentId(user.getStudentID());

        if (userDb == null) {
            CustomResponse response = new CustomResponse(false, "Không tìm thấy user!");
            return ResponseEntity.status(400).body(response);
        }

        if (userDb.getTimeStart() == 0) {
            CustomResponse response = new CustomResponse(false, "Bạn chưa bắt đầu làm bài!");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        }

        if (userDb.getTimeEnd() != 0) {
            CustomResponse response = new CustomResponse(false, "Bạn đã nộp bài trước đó!");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        }

        // Calculate score
        int score = 0;
        List<Question> questions = qRepo.getAllQuestions();
        for (int i = 0; i < user.getAnswer().size(); i++) {
            if (questions.get(i).getAnswer() == user.getAnswer().get(i)) {
                score++;
            }
        }
        
        // Store in database
        userDb.setTimeEnd(System.currentTimeMillis());
        userDb.setMyAnswers(user.getAnswerString());
        userDb.setScore(score);
        userDb.setTime(userDb.getTimeEnd() - userDb.getTimeStart());
        userRepo.save(userDb);

        CustomResponse response = new CustomResponse(true, "Nộp bài thành công!");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}

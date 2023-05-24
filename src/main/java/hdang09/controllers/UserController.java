package hdang09.controllers;

import hdang09.entities.User;
import hdang09.entities.CustomResponse;
import hdang09.entities.CustomUser;
import hdang09.entities.data.QuestionData;
import hdang09.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService service = new UserService();

    @GetMapping("/scoreboard")
    public CustomResponse getAllUser(@RequestHeader(value = "studentID", required = false) String studentID) {
        return service.getScoreboard(studentID);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<CustomResponse<User>> getUserResult(@PathVariable String studentId) {
        return service.getUserResult(studentId);
    }

    @PostMapping("/register")
    public ResponseEntity<CustomResponse<QuestionData>> register(@RequestBody User newUser) {
        return service.register(newUser);
    }

    @GetMapping("/start/{name}/{studentID}")
    public ResponseEntity<CustomResponse<QuestionData>> startTheQuiz(@PathVariable String name, @PathVariable String studentID) {
        return service.startTheQuiz(studentID);
    }

    @PutMapping("/end")
    public ResponseEntity<CustomResponse> submitTheQuiz(@RequestBody CustomUser user) {
        return service.submitTheQuiz(user);
    }

    // Don't require it
    @PutMapping("/update/{studentId}")
    public void updateUser(@RequestBody User user, @PathVariable String studentId) {
        if (studentId != null) {
            user.setStudentID(studentId);
        }
        service.updateUser(user);
    }

    @DeleteMapping("/delete/{studentId}")
    public void deleteUser(@PathVariable String studentId) {
        service.deleteUser(studentId);
    }
}

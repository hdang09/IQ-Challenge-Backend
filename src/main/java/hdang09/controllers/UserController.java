package hdang09.controllers;

import hdang09.entities.User;
import hdang09.entities.CustomResponse;
import hdang09.entities.CustomUser;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:5173", "https://iq.hdang09.site"}, maxAge = 3600)
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService service = new UserService();

    @GetMapping("/scoreboard")
    public List<User> getAllUser() {
        return service.getAllUser();
    }

    @GetMapping("/{studentId}")
    public User getUserResult(@PathVariable String studentId) {
        return service.getUserResult(studentId);
    }

    @PostMapping("/register")
    public ResponseEntity<CustomResponse> register(@RequestBody User newUser) {
        return service.register(newUser);
    }

    @GetMapping("/start/{name}/{studentID}")
    public ResponseEntity<CustomResponse> startTheQuiz(@PathVariable String name, @PathVariable String studentID) {
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

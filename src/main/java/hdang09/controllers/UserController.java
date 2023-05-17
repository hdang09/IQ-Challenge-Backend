package hdang09.controllers;

import hdang09.entites.User;
import hdang09.services.UserService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    UserService service = new UserService();

    @GetMapping("scoreboard")
    public List<User> getAllUser() {
        return service.getAllUser();
    }
    
    @GetMapping("{studentId}")
    public User getUserResult(@PathVariable int studentId) {
        return service.getUserResult(studentId);
    }
}

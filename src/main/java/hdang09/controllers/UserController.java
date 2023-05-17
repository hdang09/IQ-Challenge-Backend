package hdang09.controllers;

import hdang09.entites.User;
import hdang09.services.UserService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    @PostMapping("register")
    public void register(@RequestBody User user) {
        service.register(user);
    }
    
    // Don't require it
    @PutMapping("update/{studentId}")
    public String updateUser(@RequestBody User user, @PathVariable int studentId) {
        return service.updateUser(user, studentId);
    }
    
    @DeleteMapping("delete/{studentId}")
    public String deleteUser(@PathVariable int studentId) {
        return service.deleteUser(studentId);
    }
}

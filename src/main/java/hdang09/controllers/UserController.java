package hdang09.controllers;

import hdang09.entites.User;
import hdang09.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    @Autowired
    UserService service = new UserService();

    @GetMapping("scoreboard")
    public List<User> getAllUser() {
        return service.getAllUser();
    }
    
    @GetMapping("{studentId}")
    public User getUserResult(@PathVariable String studentId) {
        return service.getUserResult(studentId);
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(@RequestBody User newUser) {
         service.register(newUser);
    }
    
    // Don't require it
    @PutMapping("update/{studentId}")
    public void updateUser(@RequestBody User user, @PathVariable String studentId) {
        if (studentId != null) {
            user.setStudentID(studentId);
        }
         service.updateUser(user);
    }
    
    @DeleteMapping("delete/{studentId}")
    public String deleteUser(@PathVariable String studentId) {
        return service.deleteUser(studentId);
    }
    
}

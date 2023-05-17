package hdang09.API;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping("hello")
    public String listBlogs() {
        return "Welcome...";
    }

}

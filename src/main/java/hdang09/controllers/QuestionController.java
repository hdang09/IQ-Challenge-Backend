package hdang09.controllers;

import hdang09.entities.CustomQuestion;
import hdang09.entities.Question;
import hdang09.services.QuestionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://iq-api.up.railway.app", maxAge = 3600)
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService service = new QuestionService();

    @GetMapping
    public List<Question> getAllQuestion() {
        return service.getAllQuestion();
    }

    @GetMapping("{questionId}")
    public Question getQuestionById(@PathVariable int questionId) {
        return service.getQuestionById(questionId);
    }

    @PostMapping("/create")
    public void createQuestion(@RequestBody List<CustomQuestion> questions) {
        service.createQuestion(questions);
    }

    @DeleteMapping("delete/{questionId}")
    public void deleteQuestion(@PathVariable int questionId) {
        service.deleteQuestion(questionId);
    }

}

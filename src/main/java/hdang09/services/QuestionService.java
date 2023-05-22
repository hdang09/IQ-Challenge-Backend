/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hdang09.services;

import hdang09.entities.CustomQuestion;
import hdang09.entities.MultipleChoice;
import hdang09.entities.Question;
import hdang09.entities.QuestionText;
import hdang09.repositories.MultipleChoiceRepository;
import hdang09.repositories.QuestionRepository;
import hdang09.repositories.QuestionTextRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class QuestionService {

    @Autowired
    private QuestionRepository qRepo;
    @Autowired
    private MultipleChoiceRepository mcRepo;
    @Autowired
    private QuestionTextRepository qtRepo;

    public List<Question> getAllQuestion() {
        return qRepo.getAllQuestions();
    }

    public Question getQuestionById(int questionId) {
        return qRepo.findById(questionId).get();
    }

    public void createQuestion(List<CustomQuestion> questions) {
        for (CustomQuestion question : questions) {
            Question createdQuestion = qRepo.save(new Question(question.getAnswer(), question.isIsLong() ? 1 : 0));

            for (String questionText : question.getQuestion()) {
                qtRepo.save(new QuestionText(questionText, createdQuestion.getId()));
            }

            for (String multipleChoice : question.getMultipleChoice()) {
                mcRepo.save(new MultipleChoice(multipleChoice, createdQuestion.getId()));
            }
        }
    }

    public void deleteQuestion(int questionId) {
        qRepo.deleteById(questionId);
    }

}

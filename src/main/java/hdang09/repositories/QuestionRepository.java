/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hdang09.repositories;

import hdang09.entities.Question;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Admin
 */
public interface QuestionRepository extends CrudRepository<Question, Integer> {

    @Query("SELECT q FROM Question q")
    List<Question> getAllQuestions();
    
    @Query("SELECT q.id FROM Question q")
    List<Integer> getAllQuestionId();
    
    @Query("SELECT q FROM Question q WHERE q.id = :questionId")
    Question getQuestionById(@Param("questionId") int questionId);
    
    @Query("SELECT q.answer FROM Question q WHERE q.id = :questionId")
    int getAnswerById(@Param("questionId") int questionId);
}

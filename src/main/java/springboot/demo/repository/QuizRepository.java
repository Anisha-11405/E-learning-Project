package springboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import springboot.demo.entity.Quiz;
import java.util.List;


public interface QuizRepository extends JpaRepository<Quiz,Long>{
    
    @Query("SELECT q from Quiz q WHERE q.title = :title")
    List<Quiz>findByQuizTitle(@Param("title")String title);

    public Quiz findByPassMarks(Integer passMarks);
}

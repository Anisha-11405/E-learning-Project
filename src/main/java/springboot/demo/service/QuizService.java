package springboot.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import springboot.demo.entity.Quiz;
import springboot.demo.repository.QuizRepository;

@Service
public class QuizService {
    @Autowired
    QuizRepository quizrepo;
    public Quiz addQuiz(Quiz q){
        return quizrepo.save(q);
    }
    public List<Quiz>getQuiz(){
        return quizrepo.findAll();
    }
    public Quiz updateQuiz(Long id,Quiz q){
        q.setId(id);
        return quizrepo.save(q);
    }
    public String deleteQuiz(Long id){
        quizrepo.deleteById(id);
        return "Success";
    }
    public Page<Quiz>getPage(int page,int size){
        Pageable pageable=PageRequest.of(page, size);
        return quizrepo.findAll(pageable);
    }
    public List<Quiz>sortByQuiz(){
        return quizrepo.findAll(Sort.by(Sort.Direction.ASC, "difficultyLevel"));
    }
    public List<Quiz>getQuizByTitle(String title){
        return quizrepo.findByQuizTitle(title);
    }
    public Quiz getQuizByPassMarks(Integer passMarks){
        return quizrepo.findByPassMarks(passMarks);
    }
    
}

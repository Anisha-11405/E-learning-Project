package springboot.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;

import springboot.demo.entity.Quiz;
import springboot.demo.service.QuizService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
public class QuizController {
    @Autowired
    QuizService quizser;
    @PostMapping("/qadd")
    public Quiz insQuiz(@RequestBody Quiz q){
        return quizser.addQuiz(q);
    }
    @GetMapping("/qget")
    public List<Quiz>getAllQuiz(){
        return quizser.getQuiz();
    }
    @PutMapping("/qupdate/{id}")
    public Quiz updateQuiz(@PathVariable Long id,@RequestBody Quiz q){
        return quizser.updateQuiz(id, q);
    }
    @DeleteMapping("/qdelete/{id}")
    public String deleteQuizById(@PathVariable Long id){
        return quizser.deleteQuiz(id);
    }
    @GetMapping("/qpage")
    public Page<Quiz>getByPage(@RequestParam int page,@RequestParam int size){
        return quizser.getPage(page, size);
    }
    @GetMapping("/qsorting")
    public List<Quiz>sortByLevel(){
        return quizser.sortByQuiz();
    }
    @GetMapping("/qgetbytitle/{title}")
    public List<Quiz>getQuizByTitle(@PathVariable String title){
        return quizser.getQuizByTitle(title);
    }
    @GetMapping("/qfindquizbypm/{passMarks}")
    public Quiz getQuizByPassMarks(@PathVariable Integer passMarks){
        return quizser.getQuizByPassMarks(passMarks);
    }
    
    
    
    
    
}

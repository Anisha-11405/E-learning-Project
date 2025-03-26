package springboot.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.demo.entity.Discussion;
import springboot.demo.entity.Quiz;
import springboot.demo.repository.DiscussionRepository;
import springboot.demo.repository.QuizRepository;

@Service
public class DiscussionService {
    @Autowired
    DiscussionRepository discussrepo;
    @Autowired
    QuizRepository quizrepo;
    public Discussion addDiscussion(Discussion d, Long quizid){
        Quiz quiz=quizrepo.findById(quizid).orElseThrow(()->new RuntimeException("Quiz not found"));
        d.setQuiz(quiz);
        return discussrepo.save(d);
    }
    public List<Discussion>getDiscussions(){
        return discussrepo.findAll();
    }
    public Discussion updateDiscussion(Long id, Discussion d,Long quizId){
        d.setId(id);
        Quiz quiz=quizrepo.findById(quizId).orElseThrow(()->new RuntimeException("Quiz not found"));
        d.setQuiz(quiz);
        return discussrepo.save(d);
    }
    public String deleteDiscussion(Long id){
        discussrepo.deleteById(id);
        return "Success";
    }
}

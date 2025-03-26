package springboot.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import springboot.demo.entity.Discussion;
import springboot.demo.service.DiscussionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
public class DiscussionController {
    @Autowired
    DiscussionService discusser;
    @PostMapping("/dadd/{quizId}")
    public Discussion insertDiscussion(@RequestBody Discussion d,@PathVariable Long quizId){
        return discusser.addDiscussion(d,quizId);
    }
    @GetMapping("/dget")
    public List<Discussion>getAllDiscussions(){
        return discusser.getDiscussions();
    }
    @PutMapping("/dupdate/{id}/{quizId}")
    public Discussion updateDiscussion(@PathVariable Long id, @RequestBody Discussion d,@PathVariable Long quizId){
        return discusser.updateDiscussion(id, d,quizId);
    }
    @DeleteMapping("/ddelete/{id}")
    public String deleteDiscussionById(@PathVariable Long id){
        return discusser.deleteDiscussion(id);
    }
    
    
}

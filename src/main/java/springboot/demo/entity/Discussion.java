package springboot.demo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Discussion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String course;
    private String host; 
    private String replies;

    @OneToOne
    @JoinColumn(name = "quiz_id",referencedColumnName = "id")
    @JsonManagedReference
    private Quiz quiz;
    public Quiz getQuiz() {
        return quiz;
    }
    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCourse() {
        return course;
    }
    public void setCourse(String course) {
        this.course = course;
    }
    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }
    public String getReplies() {
        return replies;
    }
    public void setReplies(String replies) {
        this.replies = replies;
    }
    public Discussion() {
    }
}

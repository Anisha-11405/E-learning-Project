package springboot.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private Integer totalMarks;
    private Integer passMarks;
    private String difficultyLevel;

    @OneToOne(mappedBy = "quiz")
    @JsonBackReference
    private Discussion discussion;
    public Discussion getDiscussion() {
        return discussion;
    }
    public void setDiscussion(Discussion discussion) {
        this.discussion = discussion;
    }
    public Quiz() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Integer getTotalMarks() {
        return totalMarks;
    }
    public void setTotalMarks(Integer totalMarks) {
        this.totalMarks = totalMarks;
    }
    public Integer getPassMarks() {
        return passMarks;
    }
    public void setPassMarks(Integer passMarks) {
        this.passMarks = passMarks;
    }
    public String getDifficultyLevel() {
        return difficultyLevel;
    }
    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }
}

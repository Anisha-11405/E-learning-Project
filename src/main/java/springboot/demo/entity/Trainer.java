package springboot.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String trainerName;
    private String email;
    private LocalDate startDate;
    private LocalDate endDate;
    private String AssignedCourses;
    private String Course;
    public Trainer() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTrainerName() {
        return trainerName;
    }
    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    public String getAssignedCourses() {
        return AssignedCourses;
    }
    public void setAssignedCourses(String assignedCourses) {
        AssignedCourses = assignedCourses;
    }
    public String getCourse() {
        return Course;
    }
    public void setCourse(String course) {
        Course = course;
    }
}

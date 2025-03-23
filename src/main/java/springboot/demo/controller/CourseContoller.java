package springboot.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import springboot.demo.entity.Course;
import springboot.demo.service.CourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/courses")
public class CourseContoller {
    @Autowired
    CourseService courser;

    @PostMapping("/add")
    public ResponseEntity<Course>addCourse(@RequestBody Course course){
        Course scourse=courser.addCourse(course);
        return ResponseEntity.ok(scourse);
    }

    @GetMapping("/get")
    public List<Course> getAllCourse() {
        return courser.getCourse();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Course>getCourseById(@PathVariable Long id){
        Optional<Course>course=courser.getCourseById(id);
        return course.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    

    @PutMapping("/update/{id}")
    public ResponseEntity<Course>updateCourse(@PathVariable Long id, @RequestBody Course uCourse){
        Course course=courser.updatCourse(id, uCourse);
        return ResponseEntity.ok(course);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id) {
        return courser.deleteCourse(id);
    }

    @GetMapping("/page")
    public Page<Course> getByPage(@RequestParam int page, @RequestParam int size) {
        return courser.getPageCourse(page, size);
    }

    @GetMapping("/sorting")
    public List<Course> sortByCourses() {
        return courser.sortByCourse();
    }

    @GetMapping("/gettitle/{title}")
    public ResponseEntity<?> getByTitle(@PathVariable String title) {
        if (title.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Enter a valid course title.");
        }
        return ResponseEntity.ok(courser.getCourseByTitle(title));
    }

    @GetMapping("/findtitle/{title}")
    public ResponseEntity<?> findByTitle(@PathVariable String title) {
        if (title.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Enter a valid course title.");
        }
        return ResponseEntity.ok(courser.findCourseByTitle(title));
    }

    @GetMapping("/findbytitle/{title}")
    public ResponseEntity<?> findbytitle(@PathVariable String title) {
        if (title.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Enter a valid course title.");
        }
        return ResponseEntity.ok(courser.getByTitle(title));
    }
}

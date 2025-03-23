package springboot.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import springboot.demo.entity.Student;
import springboot.demo.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class StudentController {
    @Autowired
    private StudentService studentser;

    @PostMapping("/sdd")
    public ResponseEntity<Student> insStudent(@RequestBody Student s) { 
        Student sstu=studentser.addStudent(s);       
        return ResponseEntity.ok(sstu);
    }

    @GetMapping("/sget")
    public ResponseEntity<List<Student>> getAllStudent() {
        return ResponseEntity.ok(studentser.getStudent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student>getStudentById(@PathVariable Long id){
        Optional<Student>student=studentser.getStudentById(id);
        return student.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    

    @PutMapping("/supdate/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student ustu) {  
        Student stu=studentser.updateStudent(id, ustu);
        return ResponseEntity.ok(stu);
    }

    @DeleteMapping("/sdelete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        if (id < 0) {
            return ResponseEntity.badRequest().body("Student ID must be a positive number.");
        }
        return ResponseEntity.ok(studentser.deleteStudent(id));
    }

    @GetMapping("/spage")
    public ResponseEntity<Page<Student>> getBysPage(@RequestParam int page, @RequestParam int size) {
        return ResponseEntity.ok(studentser.getPageStudent(page, size));
    }

    @GetMapping("/ssorting")
    public ResponseEntity<List<Student>> sortByStudents() {
        return ResponseEntity.ok(studentser.sortByStudent());
    }

    @GetMapping("/getname/{name}")
    public ResponseEntity<List<Student>> getByName(@PathVariable String name) {
        return ResponseEntity.ok(studentser.getStudentByName(name));
    }

    @GetMapping("/findname/{name}")
    public ResponseEntity<List<Student>> findByName(@PathVariable String name) {
        return ResponseEntity.ok(studentser.findStudentByName(name));
    }

    @GetMapping("/findbyname/{name}")
    public ResponseEntity<?> findbyname(@PathVariable String name) {
        return ResponseEntity.ok(studentser.getbyname(name));
    }
}

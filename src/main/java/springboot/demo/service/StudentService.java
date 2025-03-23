package springboot.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import springboot.demo.entity.Student;
import springboot.demo.repository.StudentRepository;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentrepo;
    public Student addStudent(Student stu){
        if(stu.getCourses()!=null){
            stu.getCourses().forEach(course->course.setStudent(stu));
        }
        return studentrepo.save(stu);
    }
    public List<Student>getStudent(){
        return studentrepo.findAll();
    }
    public Optional<Student>getStudentById(Long id){
        return studentrepo.findById(id);
    }
    public Student updateStudent(Long id,Student ustu){
        return studentrepo.findById(id).map(stu -> {
            stu.setName(ustu.getName());
            stu.setEmail(ustu.getEmail());
            if(ustu.getCourses()!=null){
                stu.getCourses().clear();
                ustu.getCourses().forEach(course->{
                    course.setStudent(stu);
                    stu.getCourses().add(course);
                });
            }
            return studentrepo.save(stu);
        }).orElseThrow(()->new RuntimeException("Student not found"));
    }
    public String deleteStudent(Long id){
        studentrepo.deleteById(id);
        return "Success";
    }
    public Page<Student>getPageStudent(int page,int size){
        Pageable pageable=PageRequest.of(page, size);
        return studentrepo.findAll(pageable);
    }
    public List<Student>sortByStudent(){
        return studentrepo.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }
    public List<Student>getStudentByName(String name){
        return studentrepo.findByName(name);
    }
    public List<Student>findStudentByName(String name){
        return studentrepo.findByNameContaining(name);
    }
    public Student getbyname(String name){
        return studentrepo.findByname(name);
    }
}

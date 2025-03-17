package springboot.demo.service;

import java.util.List;

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
        return studentrepo.save(stu);
    }
    public List<Student>getStudent(){
        return studentrepo.findAll();
    }
    public Student updateStudent(Long id,Student stu){
        stu.setId(id);
        return studentrepo.save(stu);
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

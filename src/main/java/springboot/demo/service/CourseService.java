package springboot.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import springboot.demo.entity.Course;
import springboot.demo.repository.CourseRepository;

@Service
public class CourseService {
    @Autowired
    CourseRepository courserepo;
    public Course addCourse(Course course){
        return courserepo.save(course);
    }
    public List<Course>getCourse(){
        return courserepo.findAll();
    }
    public Course updatCourse(Long id,Course course){
        course.setId(id);
        return courserepo.save(course);
    }
    public String deleteCourse(Long id){
        courserepo.deleteById(id);
        return "Success";
    }
    public Page<Course>getPageCourse(int page,int size){
        Pageable pageable = PageRequest.of(page, size);
        return courserepo.findAll(pageable);
    }
    public List<Course>sortByCourse(){
        return courserepo.findAll(Sort.by(Sort.Direction.ASC,"title"));
    }
    public List<Course>getCourseByTitle(String title){
        return courserepo.findByTitle(title);
    }
    public List<Course>findCourseByTitle(String title){
        return courserepo.findByTitleContaining(title);
    }
    public Course getByTitle(String title){
        return courserepo.findBytitle(title);
    }
}

package springboot.demo.service;

import java.util.List;
import java.util.Optional;

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
    public Optional<Course>getCourseById(Long id){
        return courserepo.findById(id);
    }
    public Course updatCourse(Long id,Course ucourse){
        return courserepo.findById(id).map(course->{
            course.setTitle(ucourse.getTitle());
            course.setDescription(ucourse.getDescription());
            course.setInstructor(ucourse.getInstructor());
            return courserepo.save(course);
        }).orElseThrow(()->new RuntimeException("Course not found"));
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

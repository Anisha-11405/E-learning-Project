package springboot.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import springboot.demo.entity.Course;

public interface CourseRepository extends JpaRepository<Course,Long> {
    @Query("SELECT co FROM Course co WHERE co.title= :title")
    List<Course>findByTitle(@Param("title")String title);

    @Query("SELECT co FROM Course co WHERE co.title LIKE %:title%")
    List<Course>findByTitleContaining(@Param("title")String title);

    public Course findBytitle(String title);
}

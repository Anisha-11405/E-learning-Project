package springboot.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import springboot.demo.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {
    @Query("SELECT stu FROM Student stu WHERE stu.name= :name")
    List<Student>findByName(@Param("name")String name);

    @Query("SELECT stu FROM Student stu WHERE stu.name LIKE %:name%")
    List<Student>findByNameContaining(@Param("name")String name);

    public Student findByname(String name);
}

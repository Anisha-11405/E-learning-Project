package springboot.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import springboot.demo.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT us FROM User us WHERE us.username= :username")
    List<User>findByname(@Param("username")String username);

    @Query("SELECT us FROM User us WHERE us.username LIKE %:username%")
    List<User>findByNameContaining(@Param("username")String username);

    public User findByusername(String username);
}

package springboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.demo.entity.Discussion;

public interface DiscussionRepository extends JpaRepository<Discussion,Long>{
    
}

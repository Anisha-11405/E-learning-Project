package springboot.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import springboot.demo.entity.Trainer;

public interface TrainerRepository extends JpaRepository<Trainer,Long> {
    @Query("SELECT tr FROM Trainer tr WHERE tr.trainerName= :trainerName")
    List<Trainer>findByName(@Param("trainerName")String trainerName);

    @Query("SELECT tr FROM Trainer tr WHERE tr.trainerName LIKE %:trainerName%")
    List<Trainer>findByNameContaining(@Param("trainerName")String trainerName);

    public Trainer findBytrainerName(String trainerName);
}

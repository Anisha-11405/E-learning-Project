package springboot.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import springboot.demo.entity.Trainer;
import springboot.demo.service.TrainerService;

@RestController
@Validated  // Enables validation on method parameters
public class TrainerController {

    @Autowired
    private TrainerService trainerser;

    @PostMapping("/tadd")
    public ResponseEntity<?> insTrainer(@Valid @RequestBody Trainer t) {
        if (!isValidEmail(t.getEmail())) {
            return ResponseEntity.badRequest().body("Invalid email format! Please enter a valid email.");
        }
        return ResponseEntity.ok(trainerser.addTrainer(t));
    }

    @PutMapping("/tupdate/{id}")
    public ResponseEntity<?> updateTrainer(@PathVariable Long id, @Valid @RequestBody Trainer trainer) {
        if (!isValidEmail(trainer.getEmail())) {
            return ResponseEntity.badRequest().body("Invalid email format! Please enter a valid email.");
        }
        return ResponseEntity.ok(trainerser.updateTrainer(id, trainer));
    }

    @GetMapping("/tget")
    public ResponseEntity<List<Trainer>> getAllTrainers() {
        return ResponseEntity.ok(trainerser.getTrainer());
    }

    @DeleteMapping("/tdelete/{id}")
    public ResponseEntity<?> deleteTrainer(@PathVariable Long id) {
        return ResponseEntity.ok(trainerser.deleteTrainer(id));
    }

    @GetMapping("/tpage")
    public ResponseEntity<Page<Trainer>> getByPage(@RequestParam int page, @RequestParam int size) {
        return ResponseEntity.ok(trainerser.getPageTrainer(page, size));
    }

    @GetMapping("/tsorting")
    public ResponseEntity<List<Trainer>> sortByTrainers() {
        return ResponseEntity.ok(trainerser.sortByTrainer());
    }

    @GetMapping("/gettname/{trainerName}")
    public ResponseEntity<List<Trainer>> getByName(@PathVariable String trainerName) {
        return ResponseEntity.ok(trainerser.getTrainerByName(trainerName));
    }

    @GetMapping("/findtname/{trainerName}")
    public ResponseEntity<List<Trainer>> findByName(@PathVariable String trainerName) {
        return ResponseEntity.ok(trainerser.findTrainerByName(trainerName));
    }

    @GetMapping("/findbytrainername/{trainerName}")
    public ResponseEntity<Trainer> findbytrainerName(@PathVariable String trainerName) {
        return ResponseEntity.ok(trainerser.getbytrainerName(trainerName));
    }

    //  Improved email validation method
    private boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.com$");
    }
    
}

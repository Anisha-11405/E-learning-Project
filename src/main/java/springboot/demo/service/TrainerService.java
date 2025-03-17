package springboot.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import springboot.demo.entity.Trainer;
import springboot.demo.repository.TrainerRepository;

@Service
public class TrainerService {
    @Autowired
    TrainerRepository trainerrepo;
    public Trainer addTrainer(Trainer trainer){
        return trainerrepo.save(trainer);
    }
    public List<Trainer>getTrainer(){
        return trainerrepo.findAll();
    }
    public Trainer updateTrainer(Long id,Trainer trainer){
        trainer.setId(id);
        return trainerrepo.save(trainer);
    }
    public String deleteTrainer(Long id){
        trainerrepo.deleteById(id);
        return "Success";
    }
    public Page<Trainer>getPageTrainer(int page,int size){
        Pageable pageable=PageRequest.of(page, size);
        return trainerrepo.findAll(pageable);
    }
    public List<Trainer>sortByTrainer(){
        return trainerrepo.findAll(Sort.by(Sort.Direction.ASC, "trainerName"));
    }
    public List<Trainer>getTrainerByName(String trainerName){
        return trainerrepo.findByName(trainerName);
    }
    public List<Trainer>findTrainerByName(String trainerName){
        return trainerrepo.findByNameContaining(trainerName);
    }
    public Trainer getbytrainerName(String trainerName){
        return trainerrepo.findBytrainerName(trainerName);
    }
}

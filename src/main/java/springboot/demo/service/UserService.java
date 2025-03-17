package springboot.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import springboot.demo.entity.User;
import springboot.demo.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userrepo;
    public User addUser(User user){
        return userrepo.save(user);
    }
    public List<User>getUser(){
        return userrepo.findAll();
    }
    public User updateUser(Long id,User user){
        user.setId(id);
        return userrepo.save(user);
    }
    public String deleteUser(Long id){
        userrepo.deleteById(id);
        return "Success";
    }
    public Page<User>getPageUser(int page,int size){
        Pageable pageable=PageRequest.of(page, size);
        return userrepo.findAll(pageable);
    }
    public List<User>sortByUser(){
        return userrepo.findAll(Sort.by(Sort.Direction.ASC, "username"));
    }
    public List<User>getUserByName(String username){
        return userrepo.findByname(username);
    }
    public List<User>findUserByName(String username){
        return userrepo.findByNameContaining(username);
    }
    public User getbyusername(String username){
        return userrepo.findByusername(username);
    }
}

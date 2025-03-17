package springboot.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import springboot.demo.entity.User;
import springboot.demo.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userser;

    @PostMapping
    public ResponseEntity<?> insUser(@RequestBody User u) {
        List<User> existingUsers = userser.getUserByName(u.getUsername());
        if (!existingUsers.isEmpty()) {
            return ResponseEntity.badRequest().body("Username already exists! Please choose a different one.");
        }
        return ResponseEntity.ok(userser.addUser(u));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User u) {
        List<User> existingUsers = userser.getUserByName(u.getUsername());
        if (!existingUsers.isEmpty() && !existingUsers.get(0).getId().equals(id)) {
            return ResponseEntity.badRequest().body("Username already taken by another user! Please use a different one.");
        }
        return ResponseEntity.ok(userser.updateUser(id, u));
    }

    @GetMapping
    public List<User> getAllUser() {
        return userser.getUser();
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        return userser.deleteUser(id);
    }

    @GetMapping("/upage")
    public Page<User> getByPage(@RequestParam int page, @RequestParam int size) {
        return userser.getPageUser(page, size);
    }

    @GetMapping("/usorting")
    public List<User> sortbyUser() {
        return userser.sortByUser();
    }

    @GetMapping("/getusername/{username}")
    public List<User> getByName(@PathVariable String username) {
        return userser.getUserByName(username);
    }

    @GetMapping("/findusername/{username}")
    public List<User> findByUsername(@PathVariable String username) {
        return userser.findUserByName(username);
    }

    @GetMapping("/findbyusername/{username}")
    public User findByusername(@PathVariable String username) {
        return userser.getbyusername(username);
    }
}

package com.neobankx.user_service.controller;

import com.neobankx.user_service.model.User;
import com.neobankx.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }

    @GetMapping("/{email}")
    public ResponseEntity<User> getUserByEmail(@RequestParam String email){
        return userService.getUserByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }

    @PostMapping
    public ResponseEntity<User> createAccount(@RequestBody User user){
        User createUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User updateUser, @PathVariable Long id){
        return ResponseEntity.ok(userService.updateUser(updateUser, id));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

}

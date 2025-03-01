package com.neobankx.user_service.service;

import com.neobankx.user_service.model.User;
import com.neobankx.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    public Optional<User> getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User updateUser(User updateUser, Long id){
        updateUser.setId(id); // Force l'ID à celui passé dans l'URL
        return userRepository.save(updateUser);
    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }
}

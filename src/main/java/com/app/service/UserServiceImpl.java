package com.app.service;

import com.app.model.User;
import com.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;
    private final BCryptPasswordEncoder  passwordEncoder = new BCryptPasswordEncoder();
    @Autowired
    public UserServiceImpl(UserRepository userRepo){
        this.userRepo = userRepo;
    }
    @Override
    public String upsert(User user) {
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        userRepo.save(user);
        return "success";
    }
    @Override
    public User getById(Integer id) {
        return userRepo.findById(id).orElse(null);
    }
    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
    @Override
    public String deleteById(Integer id) {
        if(userRepo.existsById(id)){
            userRepo.deleteById(id);
            return "Delete Success";
        }else{
            return "No Record Found";
        }
    }
}

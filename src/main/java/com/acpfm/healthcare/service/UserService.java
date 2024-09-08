package com.acpfm.healthcare.service;

import com.acpfm.healthcare.model.User;
import com.acpfm.healthcare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    /*
    @Autowired
    private PasswordEncoder passwordEncoder;
    */

    public User registerUser(User user){
        return userRepository.save(user);
    }

    public Optional<User> getUser(Long id){
        return userRepository.findById(id);
    }

    public List<User> searchUsers(String username){
        return userRepository.findByUsernameContaining(username);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User loginUser(String username, String password) throws Exception{
        User user = userRepository.findByUsername(username).orElseThrow(() -> new Exception("Utilizador não encontrado!"));

        /*
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new Exception("Invalid credentials");
        }
        */

        return user;
    }
}

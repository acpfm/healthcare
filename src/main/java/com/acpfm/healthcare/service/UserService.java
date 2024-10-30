package com.acpfm.healthcare.service;

import com.acpfm.healthcare.model.UnidadesAtendimento;
import com.acpfm.healthcare.model.User;
import com.acpfm.healthcare.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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

    //Verifica se existe profissional e encontrando o registro com base no id passado faz a atualização
    public User updateUser(Long id, User updatedUser) {
        return userRepository.findById(id).map(existingUser -> {
            copyNonNullProperties(updatedUser, existingUser);
            return userRepository.save(existingUser);
        }).orElse(null);
    }

    // Método auxiliar para copiar apenas propriedades não nulas
    private void copyNonNullProperties(Object src, Object target) {
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }

    private String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : src.getPropertyDescriptors()) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        return emptyNames.toArray(new String[0]);
    }
}

package com.vitima.vitima.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vitima.vitima.models.User;

import com.vitima.vitima.repositores.UserRepository;
import java.util.Optional;

@Service
public class UserService {
    @Autowired

    private UserRepository userRepository;
    public User findById(Long id) {
        Optional<User> usuario = this.userRepository.findById(id);
        return usuario.orElseThrow(() -> new RuntimeException(
                "Usuário não encontrado! Id: " + id + ", Tipo: " + User.class.getName(), null));
    }

    @Transactional
    public User createUser(User obj) {
        obj.setId((null));
        obj=this.userRepository.save(obj);
        return obj;
    }

    @Transactional
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    @Transactional
    public List<User> findAllUsersPasswords(){
        return userRepository.findAll();
    }
    
    public List<String> findAllPasswords() {
        return userRepository.findAllPasswords();
    }

}

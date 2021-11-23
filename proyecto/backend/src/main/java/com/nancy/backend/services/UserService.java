package com.nancy.backend.services;

import com.nancy.backend.documents.User;
import com.nancy.backend.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    SequeceService sequeceService;

    @Autowired
    private UserRepository userRepository;

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(sequeceService.next("user"));
        }
        return userRepository.save(user);
    }

    public User findByIdCard(Long id) {
        return userRepository.findById(id).get();
    }

}

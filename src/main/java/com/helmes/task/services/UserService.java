package com.helmes.task.services;

import com.helmes.task.entities.User;
import com.helmes.task.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void addUserData(String name, List<Integer> sectors, boolean agreed){
        this.userRepository.deleteAll();
        User user = new User();
        user.setName(name);
        user.setSectors(sectors);
        user.setAgreed(agreed);
        this.userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public void changeUserData(String name, List<Integer> dbSectors, boolean agreed) {
        User user = userRepository.findAll().get(0);
        user.setName(name);
        user.setAgreed(agreed);
        user.setSectors(dbSectors);
        userRepository.save(user);
    }
}

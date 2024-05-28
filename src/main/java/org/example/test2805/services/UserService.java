package org.example.test2805.services;

import org.example.test2805.entities.User;
import org.example.test2805.repositories.UserRepository;
import org.example.test2805.requestEntities.RequestCreateUser;
import org.example.test2805.requestEntities.RequestUpdateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        return userRepository.findById(id).orElse(null);
    }
    public User addNewUser(RequestCreateUser requestCreateUser) {
        try {
            User user = new User();
            user.setFirstName(requestCreateUser.getFirstName());
            user.setLastName(requestCreateUser.getLastName());
            user.setEmail(requestCreateUser.getEmail());
            user.setPassword(requestCreateUser.getPassword());
            user.setRole(requestCreateUser.getRole());
            user.setDeleted(false);
            userRepository.save(user);
            return user;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
    public User update(String id, RequestUpdateUser requestUpdateUser) {
        try {
            User user = findById(id);
            user.setFirstName(requestUpdateUser.getFirstName());
            user.setLastName(requestUpdateUser.getLastName());
            user.setPassword(requestUpdateUser.getPassword());
            user.setEmail(requestUpdateUser.getEmail());
            user.setRole(requestUpdateUser.getRole());
            return userRepository.save(user);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
    public User delete(String id) {
        try {
            User user = findById(id);
            user.setDeleted(user.isDeleted() ? false : true);
            return userRepository.save(user);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}

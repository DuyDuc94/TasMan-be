package org.duyduclh.tasman.service.Impl;

import org.duyduclh.tasman.entity.User;
import org.duyduclh.tasman.repository.UserRepository;
import org.duyduclh.tasman.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User getUserById(Long userId) {
        if(userId == null){
            return null;
        }
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User deleteUser(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if(user == null){
            return null;
        }
        userRepository.delete(user);
        return user;
    }
}

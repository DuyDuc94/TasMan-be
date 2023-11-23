package org.duyduclh.tasman.service;

import org.duyduclh.tasman.entity.User;

import java.util.List;

public interface UserService {
    User getUserById(Long userId);
    List<User> getAllUser();
    User createUser(User user);
    User updateUser(User user);
    User deleteUser(Long userId);
}

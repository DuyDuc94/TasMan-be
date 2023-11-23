package org.duyduclh.tasman.controller;

import org.duyduclh.tasman.entity.User;
import org.duyduclh.tasman.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(path="/users", produces="application/json")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserDetails(@PathVariable("userId") Long userId){
        User user = userService.getUserById(userId);
        ResponseEntity<User> entity = new ResponseEntity<>(user,new HttpHeaders(), HttpStatus.OK);
        return entity;
    }

    @GetMapping()
    public ResponseEntity<List<User>> getAllUserDetails(){
        List<User> user = userService.getAllUser();
        ResponseEntity<List<User>> entity = new ResponseEntity<>(user,new HttpHeaders(), HttpStatus.OK);
        return entity;
    }

    @PostMapping()
    public ResponseEntity<User> createUserDetails(@RequestBody User user){
        User newUser = userService.createUser(user);
        ResponseEntity<User> entity = new ResponseEntity<>(newUser,new HttpHeaders(), HttpStatus.CREATED);
        return entity;
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<User> deleteUserDetails(@PathVariable("userId") Long userId){
        User deleteUser = userService.deleteUser(userId);
        ResponseEntity<User> entity = new ResponseEntity<>(deleteUser,new HttpHeaders(), HttpStatus.OK);
        return entity;
    }
}

package com.example.projectHQL.projectHQL.controller;

import com.example.projectHQL.projectHQL.DTO.UserDTO;
import com.example.projectHQL.projectHQL.DTO.UserPasswordDTO;
import com.example.projectHQL.projectHQL.service.UserService;
import org.apache.catalina.realm.UserDatabaseRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<UserDTO> findAllUsers (){
        return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    public UserDTO findUserById (@PathVariable Long id){
        return userService.findUserById(id);
    }

    @GetMapping("/findByName/{username}")
    public List<UserDTO> findByUserNameContains (@PathVariable String username){
        return userService.findByUserNameContains(username);
    }

    @PostMapping("/create")
    public void createUser (@RequestBody UserDTO userDTO){
       userService.createUser(userDTO);
    }

    @PostMapping("/save")
    public UserDTO saveUser (@RequestBody UserDTO userDTO){
        return userService.saveUser(userDTO);
    }

    @PutMapping("/update")
    public void updateUserPassword (@RequestBody UserPasswordDTO userPasswordDTO) {
        userService.updateUserPassword(userPasswordDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }



}

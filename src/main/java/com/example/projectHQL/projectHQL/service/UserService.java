package com.example.projectHQL.projectHQL.service;

import com.example.projectHQL.projectHQL.DTO.UserDTO;
import com.example.projectHQL.projectHQL.DTO.UserPasswordDTO;
import com.example.projectHQL.projectHQL.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<UserDTO> findAllUsers (){
        return  userRepository.findAllUsers();
    }

    public UserDTO saveUser(UserDTO userDTO){
        return userRepository.save(userDTO);
    }

    public void createUser(UserDTO userDTO){
       userRepository.createUser(userDTO.getUsername(), userDTO.getPassword());
    }

    public UserDTO findUserById(Long id){
        return userRepository.findUserById(id);
    }

    public List<UserDTO> findByUserNameContains(String username){
        return userRepository.findByUserNameContains(username);
    }

    public void updateUserPassword(UserPasswordDTO userPasswordDTO){
        userRepository.updateUserPassword(userPasswordDTO.getPassword(), userPasswordDTO.getId());
    }

    public void deleteUser (Long id){
        userRepository.deleteUser(id);
    }
}

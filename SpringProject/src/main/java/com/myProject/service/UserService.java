package com.myProject.service;


import com.myProject.entity.UserEntity;
import com.myProject.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
   public UserRepository userRepository;

   private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void saveEntry(UserEntity userEntity){
        userEntity.setPassword(passwordEncoder.encode(userEntity.getUserName()));
        userEntity.setRoles(Arrays.asList("USER"));
        userRepository.save(userEntity);
    }

    public void savenewUser(UserEntity userEntity){
        userRepository.save(userEntity);
    }


    public List<UserEntity> getAll(){
        return userRepository.findAll();
    }

    public Optional<UserEntity> findById(ObjectId id){
        return userRepository.findById(id);
    }

    public void deleteById(ObjectId id){
        userRepository.deleteById(id);
    }

    public UserEntity findbyusername(String username){
        return userRepository.findByUserName(username);
    }
}

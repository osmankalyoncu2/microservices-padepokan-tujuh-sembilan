package com.ms.idm.service;

import com.ms.idm.entity.User;
import com.ms.idm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<?> createUser(User requestBody) {
        try {
            User user = new User();
            user.setUserName(requestBody.getUserName());
            user.setAccountNumber(requestBody.getAccountNumber());
            user.setIdentityNumber(requestBody.getIdentityNumber());
            user.setEmailAddress(requestBody.getEmailAddress());

            userRepository.save(user);

            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    public List<User> getUsers() {
        List<User> users = userRepository.findAll();

        return users;
    }

    public User getUserByAccountNumber(String accountNumber) {
        Optional<User> user = userRepository.findUserByAccountNumber(accountNumber);
        System.out.println(user);
        return user.get();
    }

    public User getUserByIndentityNumber(String identityNumber) {
        Optional<User> user = userRepository.findUserByIdentityNumber(identityNumber);
        System.out.println(user);
        return user.get();
    }

    public String updateUser(User request) {
        return "Success";
    }

    public String deleteUserById(String userId) {
        return "userId";
    }
}

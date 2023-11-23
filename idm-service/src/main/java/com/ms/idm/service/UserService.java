package com.ms.idm.service;

import com.ms.idm.entity.User;
import com.ms.idm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User request) {

//        UUID uuid = UUID.randomUUID();
        User newUser = new User();
//        newUser.setId(uuid);
        newUser.setUserName(request.getUserName());
        newUser.setAccountNumber(request.getAccountNumber());
        newUser.setEmailAddress(request.getEmailAddress());
        newUser.setIdentityNumber(request.getIdentityNumber());

        userRepository.save(newUser);

        return newUser;
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
        return new User();
    }

    public String updateUser(User request) {
        return "Success";
    }

    public String deleteUserById(String userId) {
        return "userId";
    }
}

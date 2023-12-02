package com.ms.idm.controller;

import com.ms.idm.entity.User;
import com.ms.idm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody User requestBody) {
        return userService.createUser(requestBody);
    }

    @GetMapping
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping(value = "/getUserByAccountNumber/{accountNumber}")
    public ResponseEntity<?> getUserByAccountNumber(@PathVariable("accountNumber") String accountNumber) {
        return ResponseEntity.ok().body(userService.getUserByAccountNumber(accountNumber));
    }

    @GetMapping(value = "/getUserByIdenityNumber/{identityNumber}")
    public ResponseEntity<?> getUserByIdenityNumber(
            @PathVariable("identityNumber") String identityNumber
    ) {
        return ResponseEntity.ok().body(userService.getUserByIndentityNumber(identityNumber));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody User request){
        return ResponseEntity.ok().body(userService.updateUser(request));
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> deleteUserById(@RequestParam String userId){
        return ResponseEntity.ok().body(userService.deleteUserById(userId));
    }


}

package com.example.hw17.Controller;

import com.example.hw17.Model.User;
import com.example.hw17.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getAllUser(){
        List<User> UserList = userService.getAllUser();
        return ResponseEntity.status(200).body(UserList);
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();

            return ResponseEntity.status(HttpStatus.OK).body(message);
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body("User added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id ,@Valid @RequestBody User user, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();

            return ResponseEntity.status(HttpStatus.OK).body(message);
        }
        boolean isUpdated=userService.updateUser(id,user);
        if(isUpdated){
            return ResponseEntity.status(200).body("User updated");
        }
        else return ResponseEntity.status(400).body("User not existed");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id ) {

        boolean isDeleted = userService.deleteUser(id);

        if (isDeleted) {
            return ResponseEntity.status(200).body("User deleted");
        }
        return ResponseEntity.status(400).body("User not existed");

    }

}

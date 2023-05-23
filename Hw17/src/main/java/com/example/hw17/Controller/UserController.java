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

    //------------

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user) {
        User existingUser = userService.findByUsername(user.getUsername());
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            return ResponseEntity.status(HttpStatus.OK).body("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect username or password");
        }
    }

    @GetMapping("/getByEmail/{email}")
    public ResponseEntity getUserByEmail(@PathVariable String email) {
        User user = userService.findByEmail(email);
        if (user != null) {
            return ResponseEntity.status(HttpStatus.OK).body(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }


    @GetMapping("/getByRole/{role}")
    public ResponseEntity getUsersByRole(@PathVariable String role) {
        List<User> users = userService.findByRole(role);
        if (!users.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(users);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Users not found with role " + role);
        }
    }

    @GetMapping("/getByAge/{age}")
    public ResponseEntity getUsersByAge(@PathVariable Integer age) {
        List<User> users = userService.findByAge(age);
        if (!users.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(users);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Users not found with age " + age + " or above");
        }
    }




}

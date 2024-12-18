package com.example.badger.controller;

import com.example.badger.dto.UserDTO;
import com.example.badger.models.User;
import com.example.badger.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserDTO dto){
        try {
            User user = userService.create(dto);
            return  ResponseEntity.ok().body("Created user #"+String.valueOf(user.getId())+"\n" +
                    "Username: "+user.getUsername()+"\n");
        }   catch (Exception e) {
            return ResponseEntity.badRequest().body("error: "+e.toString());
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<User>> getAllUsers() {
        return ResponseEntity.ok().body(userService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok().body(userService.findById(id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id){
        userService.deleteById(id);
        return ResponseEntity.ok().body("User #"+String.valueOf(id)+" deleted");
    }

}
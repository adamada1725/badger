package com.example.badger.service;

import com.example.badger.dto.UserDTO;
import com.example.badger.models.Note;
import com.example.badger.models.User;
import com.example.badger.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {


    private UserRepository userRepo;

    public User create(UserDTO dto){
        User user = User.builder()
                .username(dto.getUsername())
                .build();
        return userRepo.save(user);
    }

    public Iterable<User> findAll(){
        return userRepo.findAll();
    }

    public Optional<User> findById(Long id){
        return userRepo.findById(id);
    }

    public Iterable<Note> getNotesByUser(Long user_id){
        return userRepo.findById(user_id).get().getNotes();
    }

    public void deleteById(Long id){
        userRepo.deleteById(id);
    }
}

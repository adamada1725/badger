package com.example.badger.service;

import com.example.badger.dto.NoteDTO;
import com.example.badger.models.Note;
import com.example.badger.models.User;
import com.example.badger.repository.NoteRepository;
import com.example.badger.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NoteService {

    private final NoteRepository noteRepo;
    private final UserRepository userRepo;

    public Note create(NoteDTO dto){
        User user = userRepo.findById(dto.getCreated_by_user_id()).get();
        Note note = Note.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .createdBy(user)
                .build();
        return noteRepo.save(note);
    }

    public Iterable<Note> findAll(){
        return noteRepo.findAll();
    }

    public Optional<Note> findById(Long id){
        return noteRepo.findById(id);
    }

    public void deleteById(Long id){
        noteRepo.deleteById(id);
    }
}

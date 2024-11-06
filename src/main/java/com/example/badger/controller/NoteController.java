package com.example.badger.controller;

//import models.Note;
import com.example.badger.models.Note;
import com.example.badger.repository.NoteRepository;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    private NoteRepository noteRepo;

    @PostMapping
    public ResponseEntity<String> createNote(@RequestBody Note note){
        try {
            noteRepo.save(note);
            return  ResponseEntity.ok().body("Created note #"+String.valueOf(note.getId())+"\n" +
                            "Title: "+note.getTitle()+"\n" +
                            "Text: "+note.getContent());
        }   catch (Exception e) {
            return ResponseEntity.badRequest().body("error: "+e.toString());
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<Note>> getNote() {
        return ResponseEntity.ok().body(noteRepo.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Note>> getNoteById(@PathVariable Long id) {
        return ResponseEntity.ok().body(noteRepo.findById(id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteNote(@PathVariable Long id){
        noteRepo.deleteById(id);
        return ResponseEntity.ok().body("Note #"+String.valueOf(id)+" deleted");
    }
}

package com.example.badger.repository;

import com.example.badger.models.Note;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note, Long> {

}

package com.example.badger.dto;

import lombok.Data;

import java.util.Optional;

@Data
public class NoteDTO {
    private String content;
    private String title;
    private Long created_by_user_id;
}

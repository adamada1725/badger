package com.example.badger.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "note")
@Builder
@Data
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = true, length = 100)
    private String title;

    @Column(nullable = false, length = 2048)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "created_by_user_id", referencedColumnName = "id", nullable = false)
    private User createdBy;
}
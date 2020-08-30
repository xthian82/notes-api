package com.example.notesapi.repository;

import com.example.notesapi.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotesRepository extends JpaRepository<Note, Long> {

    List<Note> findAllByUser(String name);
}

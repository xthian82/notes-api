package com.example.notesapi.repository;

import com.example.notesapi.entity.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepository extends JpaRepository<Note, Long> {

    Page<Note> findAllByUser(String name, Pageable pageable);

    Page<Note> findAllByUserAndTitleContainingIgnoreCase(String name, String title, Pageable pageable);
}

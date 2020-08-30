package com.example.notesapi.config;

import com.example.notesapi.entity.Note;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler
@Slf4j
public class AddUserToNote {

    @HandleBeforeCreate
    void handleCreate(Note note) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        log.info("Creating note: {} with user : {}", note, username);
        note.setUser(username);
    }
}

package com.example.notesapi.config;

import com.example.notesapi.entity.Note;
import com.example.notesapi.repository.NotesRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@AllArgsConstructor
@Slf4j
public class DataInitializer implements ApplicationRunner {

    private final NotesRepository notesRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Arrays.asList("Note 1", "Note 2", "Note 3").forEach(title -> notesRepository.save(new Note().withTitle(title).withUser("user")));

        notesRepository.findAll().forEach(note -> log.info("{}", note));
    }
}

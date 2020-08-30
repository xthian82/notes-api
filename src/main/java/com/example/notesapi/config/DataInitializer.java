package com.example.notesapi.config;

import com.example.notesapi.entity.Note;
import com.example.notesapi.repository.NotesRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.utility.RandomString;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@AllArgsConstructor
@Slf4j
public class DataInitializer implements ApplicationRunner {

    private static final String USER_NAME = "crecalde@gmail.com";
    private static final String TITLE = "Note ";

    private final NotesRepository notesRepository;

    @Override
    public void run(ApplicationArguments args) {

        for (int i = 0; i < 1000; i++) {
            notesRepository.save(new Note()
                    .withTitle(TITLE + i)
                    .withText(RandomString.make(250+ 1))
                    .withUser(USER_NAME));
        }

        notesRepository.findAll().forEach(note -> log.info("{}", note));
    }
}

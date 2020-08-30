package com.example.notesapi.controller;

import com.example.notesapi.entity.Note;
import com.example.notesapi.repository.NotesRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@AllArgsConstructor
@Slf4j
public class UserController {

    private final NotesRepository notesRepository;

    @GetMapping("/user")
    OidcUser user(@AuthenticationPrincipal OidcUser user) {
        return user;
    }

    @GetMapping("/user/notes")
    Page<Note> notes(Principal principal, String title, Pageable pageable) {
        log.info("Fetching notes with title [{}] for user {}", title, principal.getName());
        if (StringUtils.isEmpty(title)) {
            return notesRepository.findAllByUser(principal.getName(), pageable);
        }

        return notesRepository.findAllByUserAndTitleContainingIgnoreCase(principal.getName(), title, pageable);
    }

}

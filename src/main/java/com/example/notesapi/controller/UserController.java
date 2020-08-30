package com.example.notesapi.controller;

import com.example.notesapi.entity.Note;
import com.example.notesapi.repository.NotesRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

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
    List<Note> notes(Principal principal, String title) {
        log.info("notes with title [{}]", title);
        if (StringUtils.isEmpty(title)) {
            return notesRepository.findAllByUser(principal.getName());
        }

        return notesRepository.findAllByUserAndTitleContainingIgnoreCase(principal.getName(), title);
    }

}

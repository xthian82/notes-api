package com.example.notesapi.controller;

import com.example.notesapi.entity.Note;
import com.example.notesapi.repository.NotesRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

    private final NotesRepository notesRepository;

    @GetMapping("/user")
    OidcUser user(@AuthenticationPrincipal OidcUser user) {
        return user;
    }

    @GetMapping("/user/notes")
    List<Note> notes(Principal principal) {
        return notesRepository.findAllByUser(principal.getName());
    }

}

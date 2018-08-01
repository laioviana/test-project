package me.laio.project.rest;

import me.laio.project.domain.User;
import me.laio.project.security.SecurityUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.login.LoginException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/user")
public class UserResource {

    @GetMapping(value = "/current", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity findCurrentUser() throws LoginException {
        User currentUser = SecurityUtils.getCurrentUser();
        return ok(currentUser);
    }
}

package pl.mateusz1364.tasksbackend.remote.controller;

import lombok.AllArgsConstructor;
import pl.mateusz1364.tasksbackend.domain.service.AuthenticationService;
import pl.mateusz1364.tasksbackend.remote.dto.AuthenticationDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class AuthenticationInternalController {
    private static final String X_AUTH_LOGIN = "X-Auth-Login";
    private static final String X_AUTH_PASSWORD = "X-Auth-Password";
    private final AuthenticationService authenticationService;

    @PostMapping(value = "/v1/internal/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthenticationDto> getTasksForUser(
        @RequestHeader(X_AUTH_LOGIN) String login,
        @RequestHeader(X_AUTH_PASSWORD) String password) {

        return ResponseEntity.ok(authenticationService.authenticateUser(login, password));
    }
}
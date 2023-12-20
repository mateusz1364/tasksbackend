package pl.mateusz1364.tasksbackend.remote.controller.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mateusz1364.tasksbackend.domain.exception.UnauthorizedException;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<Void> handleException() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
            .build();
    }
}
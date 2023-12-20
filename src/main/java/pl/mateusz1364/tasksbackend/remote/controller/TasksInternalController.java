package pl.mateusz1364.tasksbackend.remote.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mateusz1364.tasksbackend.domain.service.TaskService;
import pl.mateusz1364.tasksbackend.remote.dto.TaskCollectionDto;

@RestController
@AllArgsConstructor
public class TasksInternalController {
    private final TaskService taskService;

    @GetMapping(value = "/v1/internal/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskCollectionDto> getTasksForUser(
        @RequestHeader("Authorization") String authentication) {
        String accessToken = authentication.replace("Bearer ", "");
        return ResponseEntity.ok(taskService.getTasksForUser(accessToken));
    }
}
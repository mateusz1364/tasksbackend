package pl.mateusz1364.tasksbackend.domain.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mateusz1364.tasksbackend.domain.exception.UnauthorizedException;
import pl.mateusz1364.tasksbackend.domain.repository.TaskRepository;
import pl.mateusz1364.tasksbackend.remote.dto.TaskCollectionDto;
import pl.mateusz1364.tasksbackend.remote.dto.TaskDto;
import pl.mateusz1364.tasksbackend.remote.mapper.TaskDtoMapper;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskDtoMapper taskDtoMapper;
    private final PasswordService passwordService;

    public TaskCollectionDto getTasksForUser(String accessToken) {
        int userId = passwordService.getUserIdFromAccessToken(accessToken)
            .orElseThrow(UnauthorizedException::new);
        List<TaskDto> tasks = taskRepository.getAllByUserId(userId)
            .stream()
            .map(taskDtoMapper::mapToDto)
            .collect(Collectors.toList());
        return new TaskCollectionDto(tasks, tasks.size());
    }
}
package pl.mateusz1364.tasksbackend.domain.repository;

import pl.mateusz1364.tasksbackend.domain.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    Task save(Task task);

    Optional<Task> getById(int id);

    List<Task> getAllByUserId(int userId);

    void deleteById(int id);
}

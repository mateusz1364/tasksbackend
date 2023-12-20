package pl.mateusz1364.tasksbackend.data.task;

import org.springframework.stereotype.Component;
import pl.mateusz1364.tasksbackend.domain.model.Task;

@Component
public class TaskEntityMapper {

    public Task mapToTask(TaskEntity taskEntity) {
        return new Task(
            taskEntity.getId(),
            taskEntity.getCreatedAt(),
            taskEntity.getName(),
            taskEntity.getDescription(),
            taskEntity.getUserId(),
            taskEntity.getReporterFirstName(),
            taskEntity.getReporterLastName(),
            taskEntity.getStreetWithNumber(),
            taskEntity.getCity()
        );
    }

    public TaskEntity mapToEntity(Task task) {
        return new TaskEntity(
            task.getId(),
            task.getCreatedAt(),
            task.getName(),
            task.getDescription(),
            task.getUserId(),
            task.getReporterFirstName(),
            task.getReporterLastName(),
            task.getStreetWithNumber(),
            task.getCity()
        );
    }
}
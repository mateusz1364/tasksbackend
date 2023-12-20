package pl.mateusz1364.tasksbackend.remote.mapper;

import org.springframework.stereotype.Component;
import pl.mateusz1364.tasksbackend.domain.model.Task;
import pl.mateusz1364.tasksbackend.domain.utils.DateUtils;
import pl.mateusz1364.tasksbackend.remote.dto.TaskDto;

@Component
public class TaskDtoMapper {
    public TaskDto mapToDto(Task task) {
        return new TaskDto(
            task.getId(),
            task.getName(),
            task.getDescription(),
            DateUtils.toEpochMs(task.getCreatedAt()),
            task.getReporterFirstName(),
            task.getReporterLastName(),
            task.getStreetWithNumber(),
            task.getCity()
        );
    }
}

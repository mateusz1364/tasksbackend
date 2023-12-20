package pl.mateusz1364.tasksbackend.remote.tapestry.mapper;

import org.springframework.stereotype.Component;
import pl.mateusz1364.tasksbackend.domain.model.Task;
import pl.mateusz1364.tasksbackend.domain.utils.DateUtils;
import pl.mateusz1364.tasksbackend.remote.tapestry.model.TaskTapestryModel;

@Component
public class TaskTapestryModelMapper {
    public TaskTapestryModel mapToTapestryModel(Task task) {
        return new TaskTapestryModel(
            task.getId(),
            DateUtils.format(task.getCreatedAt()),
            task.getName(),
            task.getDescription(),
            task.getReporterFirstName(),
            task.getReporterLastName(),
            task.getStreetWithNumber(),
            task.getCity()
        );
    }
}
package pl.mateusz1364.tasksbackend.remote.tapestry.pages;

import org.apache.tapestry5.alerts.*;
import org.apache.tapestry5.annotations.*;
import pl.mateusz1364.tasksbackend.domain.repository.TaskRepository;
import pl.mateusz1364.tasksbackend.remote.tapestry.mapper.TaskTapestryModelMapper;
import pl.mateusz1364.tasksbackend.remote.tapestry.model.TaskTapestryModel;
import pl.mateusz1364.tasksbackend.remote.tapestry.model.UserSession;

import javax.inject.Inject;
import java.util.*;
import java.util.stream.Collectors;

public class Tasks {
    @Inject
    private AlertManager alertManager;

    @Property
    private List<TaskTapestryModel> tasks;

    @Property
    private TaskTapestryModel task;

    @Inject
    private TaskRepository taskRepository;

    @Inject
    private TaskTapestryModelMapper taskTapestryModelMapper;

    @InjectPage
    private UpdateTask updateTask;

    @SessionState
    private UserSession userSession;

    Object onActivate() {
        if (Objects.isNull(userSession.getUser())) {
            alertManager.alert(Duration.TRANSIENT, Severity.ERROR, "You are not logged in");
            return Index.class;
        }
        return null;
    }

    void setupRender() {
        Integer userId = Objects.requireNonNull(userSession.getUser()).getId();
        tasks = taskRepository.getAllByUserId(Objects.requireNonNull(userId))
            .stream()
            .map(taskTapestryModelMapper::mapToTapestryModel)
            .sorted(Comparator.comparing(TaskTapestryModel::getCreatedAt).reversed())
            .collect(Collectors.toList());
    }

    Object onUpdate(int taskId) {
        userSession.setTaskIdToUpdate(taskId);
        return updateTask;
    }

    void onDelete(Integer taskId) {
        taskRepository.deleteById(taskId);
    }
}
package pl.mateusz1364.tasksbackend.remote.tapestry.pages;

import org.apache.tapestry5.alerts.*;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.annotations.Inject;
import pl.mateusz1364.tasksbackend.domain.repository.TaskRepository;
import pl.mateusz1364.tasksbackend.remote.tapestry.model.UserSession;

import java.util.Objects;

public class UpdateTask {
    @Inject
    private AlertManager alertManager;

    @InjectComponent
    private Form updateTaskForm;

    @Property
    private String name;

    @Property
    private String description;

    @Property
    private String reporterFirstName;

    @Property
    private String reporterLastName;

    @Property
    private String streetWithNumber;

    @Property
    private String city;

    @Inject
    private TaskRepository taskRepository;

    @SessionState
    private UserSession userSession;

    Object onActivate() {
        if (Objects.isNull(userSession.getUser())) {
            alertManager.alert(Duration.TRANSIENT, Severity.ERROR, "You are not logged in");
            return Index.class;
        } else if (Objects.isNull(userSession.getTaskIdToUpdate())) {
            return Tasks.class;
        }
        return null;
    }

    void setupRender() {
        Integer taskId = Objects.requireNonNull(userSession.getTaskIdToUpdate());
        taskRepository.getById(taskId)
            .ifPresent(task -> {
                name = task.getName();
                description = task.getDescription();
                reporterFirstName = task.getReporterFirstName();
                reporterLastName = task.getReporterLastName();
                streetWithNumber = task.getStreetWithNumber();
                city = task.getCity();
            });
    }

    Object onConfirm() {
        Integer taskId = userSession.getTaskIdToUpdate();
        if (Objects.nonNull(taskId)) {
            userSession.setTaskIdToUpdate(null);
            taskRepository.getById(taskId)
                .ifPresent(task -> {
                    task.setName(name);
                    task.setDescription(description);
                    task.setReporterFirstName(reporterFirstName);
                    task.setReporterLastName(reporterLastName);
                    task.setStreetWithNumber(streetWithNumber);
                    task.setCity(city);
                    taskRepository.save(task);
                });
        }
        return Tasks.class;
    }

    Object onCancel() {
        userSession.setTaskIdToUpdate(null);
        return Tasks.class;
    }
}
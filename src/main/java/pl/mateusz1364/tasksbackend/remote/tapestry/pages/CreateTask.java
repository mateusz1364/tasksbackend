package pl.mateusz1364.tasksbackend.remote.tapestry.pages;

import org.apache.tapestry5.alerts.*;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.annotations.Inject;
import pl.mateusz1364.tasksbackend.domain.model.Task;
import pl.mateusz1364.tasksbackend.domain.repository.TaskRepository;
import pl.mateusz1364.tasksbackend.remote.tapestry.model.UserSession;

import java.time.LocalDateTime;
import java.util.Objects;

public class CreateTask {
    @Inject
    private AlertManager alertManager;

    @InjectComponent
    private Form createTaskForm;

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
        }
        return null;
    }

    Object onCreate() {
        Task task = new Task(null, LocalDateTime.now(), name, description,
            Objects.requireNonNull(userSession.getUser()).getId(),
            reporterFirstName, reporterLastName, streetWithNumber, city);
        taskRepository.save(task);
        return Tasks.class;
    }
}
package pl.mateusz1364.tasksbackend.remote.tapestry.pages;

import org.apache.tapestry5.alerts.*;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.annotations.Inject;
import pl.mateusz1364.tasksbackend.domain.model.User;
import pl.mateusz1364.tasksbackend.domain.repository.UserRepository;
import pl.mateusz1364.tasksbackend.domain.service.PasswordService;
import pl.mateusz1364.tasksbackend.remote.tapestry.model.UserSession;

import java.util.Optional;

public class Index {
    @Inject
    private AlertManager alertManager;

    @InjectComponent
    private Form loginForm;

    @Property
    private String login;

    @Property
    private String password;

    @SessionState
    private UserSession userSession;

    @Inject
    private UserRepository userRepository;

    @Inject
    private PasswordService passwordService;

    Object onSignIn() {
        System.out.println(userSession);
        Optional<User> user = userRepository.findByLogin(login);
        if (user.isEmpty() ||
            !passwordService.checkSamePassword(password, user.get()
                .getPasswordHash())) {
            alertManager.alert(Duration.TRANSIENT, Severity.ERROR, "Invalid credentials");
            return Index.class;
        } else {
            userSession.setUser(user.get());
            System.out.println("Setting session");
            System.out.println(userSession);
            return Tasks.class;
        }
    }
}
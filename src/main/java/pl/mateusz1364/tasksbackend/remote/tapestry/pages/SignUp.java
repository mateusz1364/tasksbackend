package pl.mateusz1364.tasksbackend.remote.tapestry.pages;

import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.annotations.Inject;
import pl.mateusz1364.tasksbackend.domain.model.User;
import pl.mateusz1364.tasksbackend.domain.repository.UserRepository;
import pl.mateusz1364.tasksbackend.domain.service.PasswordService;

public class SignUp {
    @Inject
    private AlertManager alertManager;

    @InjectComponent
    private Form signUpForm;

    @Property
    private String login;

    @Property
    private String password;

    @Property
    private String rePassword;

    @Property
    private String firstName;

    @Property
    private String lastName;

    @Inject
    private UserRepository userRepository;

    @Inject
    private PasswordService passwordService;

    void onValidateFromSignUpForm() {
        if (!password.equals(rePassword)) {
            signUpForm.recordError("");
            alertManager.error("Passwords are not the same");
        } else if (userRepository.existByLogin(login)) {
            signUpForm.recordError("");
            alertManager.error("User exist with this login, try another one");
        }
    }

    Object onSuccessFromSignUpForm() {
        String hashedPassword = passwordService.createHash(password);
        User user = new User(null, login, firstName, lastName, hashedPassword);
        userRepository.save(user);
        alertManager.success("User successfully created");
        return Index.class;
    }
}
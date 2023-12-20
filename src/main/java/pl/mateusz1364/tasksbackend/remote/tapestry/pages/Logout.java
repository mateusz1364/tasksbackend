package pl.mateusz1364.tasksbackend.remote.tapestry.pages;

import org.apache.tapestry5.annotations.*;
import pl.mateusz1364.tasksbackend.remote.tapestry.model.UserSession;

public class Logout {
    @SessionState
    private UserSession userSession;

    Object onActivate() {
        userSession.setUser(null);
        return Index.class;
    }
}
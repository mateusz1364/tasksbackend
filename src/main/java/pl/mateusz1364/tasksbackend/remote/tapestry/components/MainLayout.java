package pl.mateusz1364.tasksbackend.remote.tapestry.components;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.annotations.*;
import pl.mateusz1364.tasksbackend.remote.tapestry.model.UserSession;
import pl.mateusz1364.tasksbackend.remote.tapestry.pages.Index;

public class MainLayout {

    @Property
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    private String title;
}
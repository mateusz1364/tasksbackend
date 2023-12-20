package pl.mateusz1364.tasksbackend.remote.tapestry.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;
import pl.mateusz1364.tasksbackend.domain.model.User;

@Getter
@Setter
public class UserSession {
    @Nullable
    private User user;
    @Nullable
    private Integer taskIdToUpdate;
}

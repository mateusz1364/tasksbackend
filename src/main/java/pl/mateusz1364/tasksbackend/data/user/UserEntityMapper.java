package pl.mateusz1364.tasksbackend.data.user;

import org.springframework.stereotype.Component;
import pl.mateusz1364.tasksbackend.domain.model.User;

@Component
public class UserEntityMapper {

    public User mapToUser(UserEntity taskEntity) {
        return new User(
            taskEntity.getId(),
            taskEntity.getLogin(),
            taskEntity.getFirstName(),
            taskEntity.getLastName(),
            taskEntity.getPasswordHash()
        );
    }

    public UserEntity mapToEntity(User task) {
        return new UserEntity(
            task.getId(),
            task.getLogin(),
            task.getFirstName(),
            task.getLastName(),
            task.getPasswordHash()
        );
    }
}

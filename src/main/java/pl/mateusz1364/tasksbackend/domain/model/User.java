package pl.mateusz1364.tasksbackend.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.lang.Nullable;

@Data
@AllArgsConstructor
public class User {
    @Nullable
    private Integer id;
    private String login;
    private String firstName;
    private String lastName;
    private String passwordHash;
}
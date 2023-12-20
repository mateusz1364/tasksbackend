package pl.mateusz1364.tasksbackend.remote.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthenticationDto {
    private Integer userId;
    private String firstName;
    private String lastName;
    private String accessToken;
    private Long expireAtMs;
}

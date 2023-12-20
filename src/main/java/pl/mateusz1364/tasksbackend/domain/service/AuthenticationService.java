package pl.mateusz1364.tasksbackend.domain.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mateusz1364.tasksbackend.domain.exception.UnauthorizedException;
import pl.mateusz1364.tasksbackend.domain.model.AccessToken;
import pl.mateusz1364.tasksbackend.domain.model.User;
import pl.mateusz1364.tasksbackend.domain.repository.UserRepository;
import pl.mateusz1364.tasksbackend.remote.dto.AuthenticationDto;

import java.util.Objects;

@Service
@AllArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordService passwordService;

    public AuthenticationDto authenticateUser(String login, String password) {
        User user = userRepository.findByLogin(login)
            .filter(it -> passwordService.checkSamePassword(password, it.getPasswordHash()))
            .orElseThrow(UnauthorizedException::new);

        AccessToken accessToken = passwordService.generateAccessToken(Objects.requireNonNull(user.getId()));
        return new AuthenticationDto(
            user.getId(),
            user.getFirstName(),
            user.getLastName(),
            accessToken.getBody(),
            accessToken.getExpireAt()
                .getTime());
    }


}

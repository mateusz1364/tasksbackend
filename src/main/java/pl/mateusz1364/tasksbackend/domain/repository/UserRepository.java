package pl.mateusz1364.tasksbackend.domain.repository;

import pl.mateusz1364.tasksbackend.domain.model.User;

import java.util.Optional;

public interface UserRepository {
    User save(User user);

    Optional<User> findByLogin(String login);

    boolean existByLogin(String login);
}
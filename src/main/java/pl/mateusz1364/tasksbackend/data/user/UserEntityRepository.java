package pl.mateusz1364.tasksbackend.data.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import pl.mateusz1364.tasksbackend.domain.model.User;
import pl.mateusz1364.tasksbackend.domain.repository.UserRepository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class UserEntityRepository implements UserRepository {
    private final UserEntityJpaRepository jpaRepository;
    private final UserEntityMapper entityMapper;

    @Override
    public User save(User user) {
        UserEntity userEntity = entityMapper.mapToEntity(user);
        UserEntity savedUserEntity = jpaRepository.save(userEntity);
        return entityMapper.mapToUser(savedUserEntity);
    }

    @Override
    public Optional<User> findByLogin(String login) {
        return jpaRepository.findByLogin(login)
            .map(entityMapper::mapToUser);
    }

    @Override
    public boolean existByLogin(String login) {
        return jpaRepository.existsByLogin(login);
    }
}

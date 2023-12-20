package pl.mateusz1364.tasksbackend.data.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserEntityJpaRepository extends JpaRepository<UserEntity, Integer> {

    boolean existsByLogin(String login);

    Optional<UserEntity> findByLogin(String login);
}

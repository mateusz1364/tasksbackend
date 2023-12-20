package pl.mateusz1364.tasksbackend.data.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mateusz1364.tasksbackend.data.user.UserEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskEntityJpaRepository extends JpaRepository<TaskEntity, Integer> {

    List<TaskEntity> findAllByUserId(int userId);
}

package pl.mateusz1364.tasksbackend.data.task;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.mateusz1364.tasksbackend.domain.model.Task;
import pl.mateusz1364.tasksbackend.domain.repository.TaskRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class TaskEntityRepository implements TaskRepository {
    private final TaskEntityJpaRepository jpaRepository;
    private final TaskEntityMapper entityMapper;

    @Override
    public Task save(Task task) {
        TaskEntity taskEntity = entityMapper.mapToEntity(task);
        TaskEntity savedTaskEntity = jpaRepository.save(taskEntity);
        return entityMapper.mapToTask(savedTaskEntity);
    }

    @Override
    public Optional<Task> getById(int id) {
        return jpaRepository.findById(id)
            .map(entityMapper::mapToTask);
    }

    @Override
    public List<Task> getAllByUserId(int userId) {
        return jpaRepository.findAllByUserId(userId)
            .stream()
            .map(entityMapper::mapToTask)
            .collect(Collectors.toList());
    }

    @Override
    public void deleteById(int id) {
        jpaRepository.deleteById(id);
    }
}

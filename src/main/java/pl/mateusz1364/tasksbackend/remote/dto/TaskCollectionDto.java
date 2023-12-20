package pl.mateusz1364.tasksbackend.remote.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskCollectionDto {
    private List<TaskDto> tasks;
    private Integer totalCount;
}
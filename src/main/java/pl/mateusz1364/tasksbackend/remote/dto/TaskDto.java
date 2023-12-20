package pl.mateusz1364.tasksbackend.remote.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
    private Integer id;
    private String name;
    private String description;
    private Long createAtMs;
    private String reporterFirstName;
    private String reporterLastName;
    private String streetWithNumber;
    private String city;
}
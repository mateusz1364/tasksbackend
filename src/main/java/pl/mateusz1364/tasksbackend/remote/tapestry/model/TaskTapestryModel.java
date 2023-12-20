package pl.mateusz1364.tasksbackend.remote.tapestry.model;

import lombok.*;

@Data
@AllArgsConstructor
public class TaskTapestryModel {
    private Integer id;
    private String createdAt;
    private String name;
    private String description;
    private String reporterFirstName;
    private String reporterLastName;
    private String streetWithNumber;
    private String city;
}
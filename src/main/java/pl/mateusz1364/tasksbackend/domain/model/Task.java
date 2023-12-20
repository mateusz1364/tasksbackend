package pl.mateusz1364.tasksbackend.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Task {
    @Nullable
    private Integer id;
    private LocalDateTime createdAt;
    private String name;
    private String description;
    private Integer userId;
    private String reporterFirstName;
    private String reporterLastName;
    private String streetWithNumber;
    private String city;
}
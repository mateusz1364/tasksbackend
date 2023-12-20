package pl.mateusz1364.tasksbackend.data.task;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "reporter_first_name")
    private String reporterFirstName;

    @Column(name = "reporter_last_name")
    private String reporterLastName;

    @Column(name = "street_with_number")
    private String streetWithNumber;

    @Column(name = "city")
    private String city;
}

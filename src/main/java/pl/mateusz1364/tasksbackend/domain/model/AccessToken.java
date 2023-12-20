package pl.mateusz1364.tasksbackend.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class AccessToken {
    public String body;
    public Date expireAt;
}

package pl.mateusz1364.tasksbackend.domain.config;

import lombok.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@Getter
public class AppCredentials {
    private final String appSecret;
    private final String databaseUrl;
    private final String databaseUsername;
    private final String databasePassword;

    public AppCredentials(Environment environment) {
        appSecret = environment.getProperty("APP_SECRET");
        databaseUrl = environment.getProperty("DATABASE_URL");
        databaseUsername = environment.getProperty("DATABASE_USERNAME");
        databasePassword = environment.getProperty("DATABASE_PASSWORD");
        System.out.println("appSecret: " + appSecret);
        System.out.println("databaseUrl: " + databaseUrl);
        System.out.println("getDatabaseUsername: " + databaseUsername);
        System.out.println("databasePassword: " + databasePassword);
    }

}
package pl.mateusz1364.tasksbackend.domain.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static String format(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        return localDateTime.format(formatter);
    }

    public static long toEpochMs(LocalDateTime localDateTime) {
        return localDateTime.atZone(ZoneId.of("UTC"))
            .toInstant()
            .toEpochMilli();
    }
}
package com.alihmzyv.logservice.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeUtil {
    public static Long toEpochMilli(LocalDateTime localDateTime) {
        return ZonedDateTime.of(localDateTime, ZoneId.systemDefault())
                .toInstant()
                .toEpochMilli();
    }
}

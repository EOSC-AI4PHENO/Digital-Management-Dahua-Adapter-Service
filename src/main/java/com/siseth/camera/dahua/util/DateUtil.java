package com.siseth.camera.dahua.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class DateUtil {

    public static String formatDate(String date, String format) {
        if(date == null || format == null)
            return null;

        try {
            return LocalDateTime
                    .parse(date.replace(" ", "T"))
                    .format(DateTimeFormatter.ofPattern(format));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}

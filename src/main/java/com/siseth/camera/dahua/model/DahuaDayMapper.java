package com.siseth.camera.dahua.model;

import java.util.Map;

public final class DahuaDayMapper {

    public static final Map<Integer, String> days
            = Map.of( 0, "SUNDAY",
                      1, "MONDAY",
                      2, "TUESDAY",
                      3, "WEDNESDAY",
                      4, "THURSDAY",
                      5, "FRIDAY",
                      6, "SATURDAY",
                      7, "HOLIDAY");


    public static String map(Integer day) {
        return days.get(day);
    }

    public static Integer getByDay(String day) {
        return days
                .entrySet()
                .stream()
                .filter(x -> x.getValue().equals(day))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

}

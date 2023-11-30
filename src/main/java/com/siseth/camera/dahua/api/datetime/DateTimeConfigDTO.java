package com.siseth.camera.dahua.api.datetime;

import com.siseth.camera.dahua.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DateTimeConfigDTO {

    private String dateTime;

    private String timezone;

    private String dateTimeFormat;

    private String date;

    private String time;

    public DateTimeConfigDTO(String dateTime, String timezone, String dateTimeFormat) {
        this.dateTime = Optional.ofNullable(DateUtil.formatDate(dateTime, dateTimeFormat))
                                                                .orElse(dateTime);
        this.timezone = timezone;
        this.dateTimeFormat = dateTimeFormat != null ?
                                        dateTimeFormat.split(" ")[0] :
                                        null;
        this.date = this.dateTime != null ?
                            this.dateTime.split(" ")[0] :
                                    null;
        this.time = this.dateTime != null ?
                            this.dateTime.split(" ")[1] :
                            null;
    }

}

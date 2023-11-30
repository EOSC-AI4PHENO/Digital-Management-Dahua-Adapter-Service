package com.siseth.camera.dahua.api.datetime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static com.siseth.camera.dahua.constant.DahuaConstant.*;

@Getter
@AllArgsConstructor
public class SetDateTimeConfigDTO {

    private String dateTime;

    private String timezone;

    private String dateTimeFormat;

    private String time;

    private String date;

    public SetDateTimeConfigDTO() {
        this.dateTime = DEFAULT_DATETIME();
        this.timezone = DEFAULT_TIMEZONE;
        this.dateTimeFormat = DEFAULT_DATETIME_FORMAT;
    }

    public String getDateTime() {
        return this.time != null && this.date != null ?
                this.date + " " + this.time :
                this.dateTime;
    }


}

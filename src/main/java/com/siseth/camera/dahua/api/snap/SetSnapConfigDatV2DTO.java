package com.siseth.camera.dahua.api.snap;

import com.siseth.camera.dahua.model.DahuaDayMapper;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static com.siseth.camera.dahua.constant.DahuaConstant.DEFAULT_SNAP_TYPE;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SetSnapConfigDatV2DTO {

    private String dayName;

    private Boolean isEnable;

    private String timeFrom;

    private String timeTo;

    @Hidden
    public String getData() {
        return (this.isEnable ? DEFAULT_SNAP_TYPE : "0") +
                " " +
                this.timeFrom +
                "-" +
                this.timeTo;

    }

    @Hidden
    public Integer getDayInt() {
        return DahuaDayMapper.getByDay(this.dayName);
    }




}

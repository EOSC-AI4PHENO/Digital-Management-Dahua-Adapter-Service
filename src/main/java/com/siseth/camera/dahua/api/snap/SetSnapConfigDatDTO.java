package com.siseth.camera.dahua.api.snap;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SetSnapConfigDatDTO {

    private Integer day;

    private String type;

    private String timeRange;

    @Hidden
    public String getData() {
        if(this.type == null || timeRange == null)
            return null;
        return this.type + " " + this.timeRange;
    }
}

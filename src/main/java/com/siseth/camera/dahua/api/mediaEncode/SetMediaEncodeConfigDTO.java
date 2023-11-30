package com.siseth.camera.dahua.api.mediaEncode;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

import static com.siseth.camera.dahua.constant.DahuaConstant.DEFAULT_FPS;
import static com.siseth.camera.dahua.constant.DahuaConstant.DEFAULT_QUALITY;

@Getter
public class SetMediaEncodeConfigDTO {

    private String channel;

    private String fps;

    private String quality;

    private BigDecimal minutes;

    public String getChannel() {
        return Optional.ofNullable(channel).orElse("0");
    }

    public SetMediaEncodeConfigDTO() {
        this.fps = DEFAULT_FPS;
        this.quality = DEFAULT_QUALITY;
    }



    public String getFps() {
        return this.minutes != null ?
                    new BigDecimal(1)
                            .divide(new BigDecimal(60), 6, RoundingMode.CEILING)
                            .divide(this.minutes, 6, RoundingMode.CEILING).toString() :
                this.fps;
    }



}


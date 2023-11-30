package com.siseth.camera.dahua.api.mediaEncode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Map;

import static com.siseth.camera.dahua.constant.DahuaConstant.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MediaEncodeConfigDTO {

    private MediaEncodeConfigItemDTO config;

    public MediaEncodeConfigDTO(Map<String, String> map, String channel) {
        if(map.get(getEncodeFPS(channel)) == null)
            return;
        this.config = new MediaEncodeConfigItemDTO(
                map.get(getEncodeFPS(channel)),
                map.get(getEncodeQuality(channel)),
                map.get(getEncodeQualityRange(channel))
        );
    }


    @NoArgsConstructor
    @Getter
    public class MediaEncodeConfigItemDTO {

        private String fps;

        private String quality;

        private String qualityRange;

        private BigDecimal minutes;

        public MediaEncodeConfigItemDTO(String ftp, String quality, String qualityRange) {
            this.fps = ftp;
            this.quality = quality;
            this.qualityRange = qualityRange;
            this.minutes = ftp != null ?
                                BigDecimal.ONE
                                        .divide(new BigDecimal(60), 6, RoundingMode.CEILING)
                                        .divide(new BigDecimal(ftp), 0, RoundingMode.CEILING)
                                        :
                                null;


        }


    }

}


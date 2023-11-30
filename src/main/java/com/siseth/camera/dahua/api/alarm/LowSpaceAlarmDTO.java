package com.siseth.camera.dahua.api.alarm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

import static com.siseth.camera.dahua.constant.DahuaConstant.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LowSpaceAlarmDTO {
    private LowSpaceAlarmItemDTO item;

    public LowSpaceAlarmDTO(Map<String, String> map){
        if(map.get(LOW_SPACE_ENABLE) == null)
            return;
        this.item = new LowSpaceAlarmItemDTO(
                map.get(LOW_SPACE_ENABLE),
                map.get(LOW_SPACE_MAIL_ENABLE),
                map.get(LOW_SPACE_LOWER_LIMIT)
        );
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public class LowSpaceAlarmItemDTO {

        private String enable;

        private String mailEnable;

        private String lowerLimit;

    }

}


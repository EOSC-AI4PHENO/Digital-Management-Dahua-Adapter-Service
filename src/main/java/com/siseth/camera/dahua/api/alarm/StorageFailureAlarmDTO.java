package com.siseth.camera.dahua.api.alarm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

import static com.siseth.camera.dahua.constant.DahuaConstant.STORAGE_FAILURE_ENABLE;
import static com.siseth.camera.dahua.constant.DahuaConstant.STORAGE_FAILURE_MAIL_ENABLE;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class StorageFailureAlarmDTO {

    private StorageFailureAlarmItemDTO item;

    public StorageFailureAlarmDTO(Map<String, String> map){
        if(map.get(STORAGE_FAILURE_ENABLE) == null)
            return;
        this.item = new StorageFailureAlarmItemDTO(
                map.get(STORAGE_FAILURE_ENABLE),
                map.get(STORAGE_FAILURE_MAIL_ENABLE)
        );
    }


    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public class StorageFailureAlarmItemDTO {

        private String enable;

        private String mailEnable;

    }

}


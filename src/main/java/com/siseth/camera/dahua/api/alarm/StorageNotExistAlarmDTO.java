package com.siseth.camera.dahua.api.alarm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

import static com.siseth.camera.dahua.constant.DahuaConstant.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class StorageNotExistAlarmDTO {

    private StorageNotExistAlarmItemDTO item;

    public StorageNotExistAlarmDTO(Map<String, String> map){
        if(map.get(STORAGE_NOT_EXIST_ENABLE) == null)
            return;
        this.item = new StorageNotExistAlarmItemDTO(
                map.get(STORAGE_NOT_EXIST_ENABLE),
                map.get(STORAGE_NOT_EXIST_MAIL_ENABLE),
                map.get(STORAGE_NOT_EXIST_SNAPSHOT)
        );
    }



    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public class StorageNotExistAlarmItemDTO {

        private String enable;

        private String mailEnable;

        private String snapshot;

    }

}


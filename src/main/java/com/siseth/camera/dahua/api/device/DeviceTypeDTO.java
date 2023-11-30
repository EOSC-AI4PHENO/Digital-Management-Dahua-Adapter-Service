package com.siseth.camera.dahua.api.device;

import com.siseth.camera.dahua.api.mediaEncode.MediaEncodeConfigDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

import static com.siseth.camera.dahua.constant.DahuaConstant.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DeviceTypeDTO {

    private DeviceTypeItemDTO info;

    public DeviceTypeDTO(Map<String, String> map) {
        if(map.get(DEVICE_TYPE_INFO) == null)
            return;
        this.info = new DeviceTypeItemDTO(
                                            map.get(DEVICE_TYPE_INFO),
                                            map.get(HARDWARE_VERSION),
                                            map.get(SERIAL_NUMBER)
                                            );
    }
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public class DeviceTypeItemDTO {

        private String deviceType;

        private String hardwareVersion;

        private String serialNumber;


    }

}

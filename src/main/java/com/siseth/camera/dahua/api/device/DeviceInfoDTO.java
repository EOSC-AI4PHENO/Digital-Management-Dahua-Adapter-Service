package com.siseth.camera.dahua.api.device;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.siseth.camera.dahua.constant.DahuaConstant.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DeviceInfoDTO {

    private List<DeviceInfoItemDTO> items = new ArrayList<>();


    public DeviceInfoDTO(Map<String, String> map){
        int i = 0;
        while(map.get(getDeviceName(i)) != null ) {
            items.add(new DeviceInfoItemDTO(i, map));
            i++;
        }

    }


    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public class DeviceInfoItemDTO {

        private String name;

        private String state;

        private List<DeviceInfoItemDetailDTO> details = new ArrayList<>();

        public DeviceInfoItemDTO(int i, Map<String, String> map) {
            int j = 0;
            this.name = map.get(getDeviceName(i));
            this.state = map.get(getDeviceState(i));
            while(map.get(getDevicePath(i,j )) != null ) {
                details.add(new DeviceInfoItemDetailDTO(i, j, map));
                j++;
            }



        }



        @AllArgsConstructor
        @NoArgsConstructor
        @Getter
        public class DeviceInfoItemDetailDTO {

            private String path;

            private String totalBytes;

            private String type;

            private String usedBytes;

            public DeviceInfoItemDetailDTO(int i, int j, Map<String, String> map) {
                this.path = map.get(getDevicePath(i, j));
                this.totalBytes = map.get(getDeviceTotalBytes(i, j));
                this.type = map.get(getDeviceType(i, j));
                this.usedBytes = map.get(getDeviceUsedBytes(i, j));
            }

        }
    }

}


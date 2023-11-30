package com.siseth.camera.dahua.api.nas;

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
public class NasConfigDTO {

    private List<NasConfigItemDTO> items;

    public NasConfigDTO(Map<String, String> map) {
        items = new ArrayList<>();

        int i = 0;
        while(map.get(getNasProtocol(i)) != null){
            if(map.get(getNasProtocol(i)).equals(FTP)){
                items.add(
                        new NasConfigItemDTO(
                                i,
                                map.get(getNasProtocol(i)),
                                map.get(getNasAddress(i)),
                                map.get(getNasDirectory(i)),
                                map.get(getNasEnable(i)),
                                map.get(getNasPort(i)),
                                map.get(getNasUser(i))
                        )
                );
            }
            i++;
        }


    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public class NasConfigItemDTO{

        private Integer index;

        private String protocol;

        private String address;

        private String directory;

        private String enable;

        private String port;

        private String user;

    }
}


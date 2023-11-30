package com.siseth.camera.dahua.api.snap;

import com.siseth.camera.dahua.api.nas.NasConfigDTO;
import com.siseth.camera.dahua.model.DahuaDayMapper;
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
public class SnapConfigDTO {

    private List<SnapConfigItemDTO> items;

    public SnapConfigDTO(String channel, Map<String, String> map) {
        items = new ArrayList<>();

        int i = 0;
        while(map.get(getSnapSection(channel, i)) != null){
                items.add(
                        new SnapConfigItemDTO(
                                channel,
                                i,
                                map
                        )
                );
            i++;
        }


    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public class SnapConfigItemDTO {

        private Integer day;

        private String dayName;

        private Boolean isEnable;

        private String timeFrom;

        private String timeTo;

        public SnapConfigItemDTO(String channel, Integer i, Map<String, String> map) {
            String result = map.get(getSnapSection(channel, i));
            this.day = i;
            this.dayName = DahuaDayMapper.map(i);
            String[] resultList = result != null ?
                                        result.split(" ") :
                                        null;
            this.timeFrom = resultList != null ?
                                resultList[1].split("-")[0] :
                                null;
            this.timeTo = resultList != null ?
                                resultList[1].split("-")[1] :
                                null;
            this.isEnable = resultList != null ?
                                !resultList[0].equals("0") :
                                null;
        }

    }
}

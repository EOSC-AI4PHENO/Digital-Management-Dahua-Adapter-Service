package com.siseth.camera.dahua.api.snap;

import com.siseth.camera.dahua.model.DahuaDayMapper;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.siseth.camera.dahua.constant.DahuaConstant.*;

@AllArgsConstructor
@Getter
public class SetSnapConfigDTO {

    private List<SetSnapConfigDatV2DTO> schedule;

    private String channel;

    public String getChannel() {
        return Optional.ofNullable(this.channel).orElse("0");
    }

    public SetSnapConfigDTO() {
        this.schedule =
                DahuaDayMapper
                        .days.values()
                        .stream()
                        .map(s -> new SetSnapConfigDatV2DTO(s,
                                                            true,
                                                            DEFAULT_SNAP_TIME_FROM,
                                                            DEFAULT_SNAP_TIME_TO))
                        .collect(Collectors.toList());
    }

    public String getDaysString() {
        return this.schedule
                .stream()
                .filter(SetSnapConfigDatV2DTO::getIsEnable)
                .map(SetSnapConfigDatV2DTO::getDayName)
                .collect(Collectors.joining(","));
    }



}

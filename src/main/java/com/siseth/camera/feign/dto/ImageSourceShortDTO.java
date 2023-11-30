package com.siseth.camera.feign.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImageSourceShortDTO {

    private String name;

    private String desc;

    private String url;

    private Integer port;

    private String cameraUser;

    private String cameraPassword;


}

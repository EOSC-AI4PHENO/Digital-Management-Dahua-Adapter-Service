package com.siseth.camera.dahua.api.connect;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ConnectDataDTO {

    private String user;

    private String password;

    private String url; //Start with http

    private Integer port;

    public String getUrl() {
        return this.url + ":" + this.port;
    }
}

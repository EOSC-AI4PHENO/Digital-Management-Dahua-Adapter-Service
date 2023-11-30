package com.siseth.camera.dahua.api.nas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SetNasConfigDTO {

    private Integer index;

    private String protocol;

    private String address;

    private String directory;

    private String enable;

    private String port;

    private String password;

    private String user;

    public Integer getIndex() {
        return Optional.ofNullable(this.index).orElse(0);
    }

    public String getProtocol() {
        return Optional.ofNullable(this.protocol).orElse("FTP");
    }

}

package com.siseth.camera.dahua.config;

import org.apache.http.client.config.RequestConfig;

public class DahuaConfig {

    private static final Integer TIMEOUT_IN_SECOND = 5;

    public static RequestConfig getTimeoutConfig() {
        return RequestConfig.custom()
                .setConnectTimeout(TIMEOUT_IN_SECOND * 1000)
                .setConnectionRequestTimeout(TIMEOUT_IN_SECOND * 1000)
                .setSocketTimeout(TIMEOUT_IN_SECOND * 1000).build();
    }

}

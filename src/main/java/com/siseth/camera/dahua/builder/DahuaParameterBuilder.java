package com.siseth.camera.dahua.builder;

import static com.siseth.camera.dahua.constant.DahuaUrl.*;

public class DahuaParameterBuilder {
    private String url;
    public DahuaParameterBuilder(String url) {
        this.url = url;
    }

    public static DahuaParameterBuilder DahuaGETBuilder() {
        return new DahuaParameterBuilder(GET_CONFIG);
    }

    public static DahuaParameterBuilder DahuaSETBuilder() {
        return new DahuaParameterBuilder(SET_CONFIG);
    }
    public static DahuaParameterBuilder DahuaSETTime() {
        return new DahuaParameterBuilder(SET_CURRENT_TIME);
    }

    public static DahuaParameterBuilder DahuaMediaFinder(){
        return new DahuaParameterBuilder(FIND_MEDIA);
    }

    public static DahuaParameterBuilder DahuaMediaGetFile(){
        return new DahuaParameterBuilder(FIND_NEXT_FILE);
    }

    public DahuaParameterBuilder addName(String name) {
        this.url = this.url + "&name=" + name;
        return this;
    }

    public DahuaParameterBuilder addParameter(String key, String value){
        if(value != null)
            this.url = this.url + "&" + key + "=" + value;
        return this;
    }

    public String build() {
        System.out.println("BUILDED URL = "+this.url);
        return this.url;
    }

}



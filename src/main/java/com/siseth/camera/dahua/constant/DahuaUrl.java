package com.siseth.camera.dahua.constant;

import lombok.SneakyThrows;

import java.net.URLEncoder;

public final class DahuaUrl {

    public final static String GET_CURRENT_TIME = "global.cgi?action=getCurrentTime";

    public final static String GET_CONFIG = "configManager.cgi?action=getConfig";

    public final static String SET_CURRENT_TIME = "global.cgi?action=setCurrentTime";

    public final static String SET_CONFIG = "configManager.cgi?action=setConfig";

    public final static String MEDIA_FINDER_STEP_1 = "mediaFileFind.cgi?action=factory.create";

    public final static String DOWNLOAD_FILE = "RPC_Loadfile";

    public final static String FIND_MEDIA = "mediaFileFind.cgi?action=findFile";

    public final static String MEDIA_FINDER_STEP_4 = "mediaFileFind.cgi?action=close&object=";

    public final static String MEDIA_FINDER_STEP_5 = "mediaFileFind.cgi?action=destroy&object=";

    public final static String FIND_NEXT_FILE = "mediaFileFind.cgi?action=findNextFile";

    public final static String DEVICE_ALL_INFO = "storageDevice.cgi?action=getDeviceAllInfo";

    public final static String DEVICE_TYPE_INFO = "magicBox.cgi?action=getSystemInfo";

    public final static String SNAPSHOT = "snapshot.cgi";

    @SneakyThrows
    public static String getFile(String name) {
        return DOWNLOAD_FILE + URLEncoder.encode(name, "UTF-8");
    }

    public final static String NTP = "NTP";

    public final static String NAS = "NAS";

    public final static String LOCALES = "Locales";
    public final static String ENCODE = "Encode";

    public final static String SNAP = "Snap";

    public final static String LOW_SPACE_ALARM = "StorageLowSpace";

    public final static String STORAGE_FAILURE_ALARM = "StorageFailure";

    public final static String STORAGE_NOT_EXIST_ALARM = "StorageNotExist";
}



package com.siseth.camera.dahua.model;

import com.siseth.camera.dahua.api.alarm.LowSpaceAlarmDTO;
import com.siseth.camera.dahua.api.alarm.StorageFailureAlarmDTO;
import com.siseth.camera.dahua.api.alarm.StorageNotExistAlarmDTO;
import com.siseth.camera.dahua.api.file.DahuaFilesDTO;
import com.siseth.camera.dahua.api.mediaEncode.MediaEncodeConfigDTO;
import com.siseth.camera.dahua.api.nas.NasConfigDTO;

import java.io.File;

public interface DahuaInterface {

    String getCurrentDate();

    String getTimezone();

    NasConfigDTO getNASConfig();

    String getDateTimeFormat();

    String setDateFormat(String dateFormat);

    String setTimezone(String timezone);

    File getFile(String name);

    DahuaFilesDTO getFiles(String dir, String from, String to, String channel);

    LowSpaceAlarmDTO getLowSpaceAlarmConfig();

    StorageFailureAlarmDTO getStorageFailureAlarmConfig();

    StorageNotExistAlarmDTO getStorageNotExistsAlarmAlarmConfig();

    MediaEncodeConfigDTO getEncodeMedia(String channel);

    byte[] getSnapshot(String channel);

}

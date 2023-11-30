package com.siseth.camera.dahua.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DahuaConstant {


    public static String DEFAULT_DATETIME() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public static final String DEFAULT_TIMEZONE = "0";

    public static final String DEFAULT_DATETIME_FORMAT = "Y-M-D H-m-S";

    public static final String DEFAULT_FPS = "0.00055555";

    public static final String DEFAULT_QUALITY = "5";

    public static final String DEFAULT_SNAP_TYPE = "1";

    public static final String DEFAULT_SNAP_TIME_RANGE = "05:00:00-21:00:00";

    public static final String DEFAULT_SNAP_TIME_FROM = "05:00:00";

    public static final String DEFAULT_SNAP_TIME_TO = "21:00:00";
    //TAGI
    public static final String RESULT_DEFAULT = "result";

    public static final String LOCALES_TAG = "table.Locales.TimeFormat";

    public static final String TIMEZONE_TAG = "table.NTP.TimeZone";

    public static final String TIMEZONE_SET = "NTP.TimeZone";

    public static final String TIMEFORMAT_SET = "Locales.TimeFormat";

    public static final String OBJECT = "object";

    public static final String COND_DIR = "condition.Dirs[0]";

    public static final String COND_START = "condition.StartTime";

    public static final String COND_END = "condition.EndTime";

    public static final String COND_CHANNEL = "condition.Channel";

    public static final String COUNT = "count";




    //DEVICE TYPE
    public static final String DEVICE_TYPE_INFO = "deviceType";

    public static final String HARDWARE_VERSION = "hardwareVersion";

    public static final String SERIAL_NUMBER = "serialNumber";



    //DATE TIME
    public static final String TIME = "time";



    //FILES
    public static String FILE_PATH = "items[{{i}}].FilePath";
    public static String getFilePath(int i){
        return FILE_PATH.replace("{{i}}", String.valueOf(i));
    }

    public static String FILE_START = "items[{{i}}].StartTime";
    public static String getFileStart(int i){
        return FILE_START.replace("{{i}}", String.valueOf(i));
    }

    public static String FILE_LENGTH = "items[{{i}}].Length";
    public static String getFileLength(int i){
        return FILE_LENGTH.replace("{{i}}", String.valueOf(i));
    }


    public static String FILE_TYPE = "items[{{i}}].Type";

    public static String getFileType(int i){
        return FILE_TYPE.replace("{{i}}", String.valueOf(i));
    }

    public static String WORK_DIR = "items[{{i}}].WorkDir";

    public static String getWorkDir(int i){
        return WORK_DIR.replace("{{i}}", String.valueOf(i));
    }



    //MEDIA ENCODE
    public static String ENCODE_FPS = "table.Encode[{{channel}}].SnapFormat[0].Video.FPS";
    public static String getEncodeFPS(String channel) {
        return ENCODE_FPS.replace("{{channel}}", channel);
    }
    public static String ENCODE_QUALITY = "table.Encode[{{channel}}].SnapFormat[0].Video.Quality";
    public static String getEncodeQuality(String channel) {
        return ENCODE_QUALITY.replace("{{channel}}", channel);
    }
    public static String ENCODE_QUALITY_RANGE = "table.Encode[{{channel}}].SnapFormat[0].Video.QualityRange";
    public static String getEncodeQualityRange(String channel) {
        return ENCODE_QUALITY_RANGE.replace("{{channel}}", channel);
    }

    public static String ENCODE_FPS_SET = "Encode[{{channel}}].SnapFormat[0].Video.FPS";
    public static String setEncodeFPS(String channel) {
        return ENCODE_FPS_SET.replace("{{channel}}", channel);
    }
    public static String ENCODE_QUALITY_SET = "Encode[{{channel}}].SnapFormat[0].Video.Quality";
    public static String setEncodeQuality(String channel) {
        return ENCODE_QUALITY_SET.replace("{{channel}}", channel);
    }









    //NAS
    public static String NAS_PROTOCOL = "table.NAS[{{i}}].Protocol";
    public static String getNasProtocol(int index) {
        return NAS_PROTOCOL.replace("{{i}}", String.valueOf(index));
    }
    public static String NAS_ADDRESS = "table.NAS[{{i}}].Address";
    public static String getNasAddress(int index) {
        return NAS_ADDRESS.replace("{{i}}", String.valueOf(index));
    }
    public static String NAS_DIRECTORY = "table.NAS[{{i}}].Directory";
    public static String getNasDirectory(int index) {
        return NAS_DIRECTORY.replace("{{i}}", String.valueOf(index));
    }
    public static String NAS_ENABLE = "table.NAS[{{i}}].Enable";
    public static String getNasEnable(int index) {
        return NAS_ENABLE.replace("{{i}}", String.valueOf(index));
    }
    public static String NAS_PORT = "table.NAS[{{i}}].Port";
    public static String getNasPort(int index) {
        return NAS_PORT.replace("{{i}}", String.valueOf(index));
    }
    public static String NAS_USER = "table.NAS[{{i}}].UserName";
    public static String getNasUser(int index) {
        return NAS_USER.replace("{{i}}", String.valueOf(index));
    }
    public static String FTP = "FTP";

    public static String NAS_PROTOCOL_SET = "NAS[{{i}}].Protocol";
    public static String setNasProtocol(int index) {
        return NAS_PROTOCOL_SET.replace("{{i}}", String.valueOf(index));
    }
    public static String NAS_ADDRESS_SET = "NAS[{{i}}].Address";
    public static String setNasAddress(int index) {
        return NAS_ADDRESS_SET.replace("{{i}}", String.valueOf(index));
    }
    public static String NAS_DIRECTORY_SET = "NAS[{{i}}].Directory";
    public static String setNasDirectory(int index) {
        return NAS_DIRECTORY_SET.replace("{{i}}", String.valueOf(index));
    }
    public static String NAS_ENABLE_SET = "NAS[{{i}}].Enable";
    public static String setNasEnable(int index) {
        return NAS_ENABLE_SET.replace("{{i}}", String.valueOf(index));
    }
    public static String NAS_PORT_SET = "NAS[{{i}}].Port";
    public static String setNasPort(int index) {
        return NAS_PORT_SET.replace("{{i}}", String.valueOf(index));
    }
    public static String NAS_USER_SET = "NAS[{{i}}].UserName";
    public static String setNasUser(int index) {
        return NAS_USER_SET.replace("{{i}}", String.valueOf(index));
    }

    public static String NAS_PASSWORD_SET = "NAS[{{i}}].Password";
    public static String setNasPassword(int index) {
        return NAS_PASSWORD_SET.replace("{{i}}", String.valueOf(index));
    }




    //SNAP
    public static String SNAP_SECTION = "table.Snap[{{channel}}].TimeSection[{{day}}][0]";
    //day - 0 Sunday, 6 - Saturday
    public static String getSnapSection(String channel, int day) {
        return SNAP_SECTION
                .replace("{{channel}}", String.valueOf(channel))
                .replace("{{day}}", String.valueOf(day));
    }

    public static String SNAP_SECTION_SET = "Snap[{{channel}}].TimeSection[{{day}}][0]";

    public static String setSnapSection(String channel, int day) {
        return SNAP_SECTION_SET
                .replace("{{channel}}", String.valueOf(channel))
                .replace("{{day}}", String.valueOf(day));
    }



    //STORAGE GROUP
    public static String STORAGE_GROUP_PICTURE = "StorageGroup[{{i}}].PicturePathRule";
    public static String setStorageGroupPicture(Integer i) {
        return STORAGE_GROUP_PICTURE
                .replace("{{i}}", String.valueOf(i));
    }
    public static String STORAGE_GROUP_RECORD = "StorageGroup[{{i}}].RecordPathRule";
    public static String setStorageGroupRecord(Integer i) {
        return STORAGE_GROUP_RECORD
                .replace("{{i}}", String.valueOf(i));
    }

    public static String RECORD_TIMING_LOCAL = "RecordStoragePoint[{{i}}].TimingSnapShot.Local";
    public static String setRecordTimingLocal(Integer i) {
        return RECORD_TIMING_LOCAL
                .replace("{{i}}", String.valueOf(i));
    }

    public static String RECORD_TIMING_FTP = "RecordStoragePoint[{{i}}].TimingSnapShot.FTP";
    public static String setRecordTimingFTP(Integer i) {
        return RECORD_TIMING_FTP
                .replace("{{i}}", String.valueOf(i));
    }

    public static String RECORD_EVENT_LOCAL = "RecordStoragePoint[{{i}}].EventSnapShot.Local";
    public static String setRecordEventLocal(Integer i) {
        return RECORD_EVENT_LOCAL
                .replace("{{i}}", String.valueOf(i));
    }
    public static String RECORD_EVENT_FTP = "RecordStoragePoint[{{i}}].EventSnapShot.FTP";
    public static String setRecordEventFTP(Integer i) {
        return RECORD_EVENT_FTP
                .replace("{{i}}", String.valueOf(i));
    }

    public static String RECORD_ALARM_LOCAL = "RecordStoragePoint[{{i}}].AlarmSnapShot.Local";
    public static String setRecordAlarmLocal(Integer i) {
        return RECORD_ALARM_LOCAL
                .replace("{{i}}", String.valueOf(i));
    }
    public static String RECORD_ALARM_FTP = "RecordStoragePoint[{{i}}].AlarmSnapShot.FTP";
    public static String setRecordAlarmFTP(Integer i) {
        return RECORD_ALARM_FTP
                .replace("{{i}}", String.valueOf(i));
    }

    public static String RECORD_ALARM_EMERGENCY = "RecordStoragePoint[{{i}}].AlarmRecord.LocalForEmergency";
    public static String setRecordAlarmEmergency(Integer i) {
        return RECORD_ALARM_EMERGENCY
                .replace("{{i}}", String.valueOf(i));
    }
    public static String RECORD_EVENT_EMERGENCY = "RecordStoragePoint[{{i}}].EventRecord.LocalForEmergency";
    public static String setRecordEventEmergency(Integer i) {
        return RECORD_EVENT_EMERGENCY
                .replace("{{i}}", String.valueOf(i));
    }
    public static String RECORD_EVENT_SNAP_EMERGENCY = "RecordStoragePoint[{{i}}].EventSnapShot.LocalForEmergency";
    public static String setRecordEventSnapEmergency(Integer i) {
        return RECORD_EVENT_SNAP_EMERGENCY
                .replace("{{i}}", String.valueOf(i));
    }
    public static String RECORD_MANUAL_EMERGENCY = "RecordStoragePoint[{{i}}].ManualRecord.LocalForEmergency";
    public static String setRecordManualEmergency(Integer i) {
        return RECORD_MANUAL_EMERGENCY
                .replace("{{i}}", String.valueOf(i));
    }
    public static String RECORD_TIMING_EMERGENCY = "RecordStoragePoint[{{i}}].TimingRecord.LocalForEmergency";
    public static String setRecordTimingEmergency(Integer i) {
        return RECORD_TIMING_EMERGENCY
                .replace("{{i}}", String.valueOf(i));
    }
    public static String RECORD_MANUAL_SNAP_EMERGENCY = "RecordStoragePoint[{{i}}].ManualSnapShot.LocalForEmergency";
    public static String setRecordManualSnapEmergency(Integer i) {
        return RECORD_MANUAL_SNAP_EMERGENCY
                .replace("{{i}}", String.valueOf(i));
    }
    public static String RECORD_TIMING_SNAP_EMERGENCY = "RecordStoragePoint[{{i}}].TimingSnapShot.LocalForEmergency";
    public static String setRecordTimingSnapEmergency(Integer i) {
        return RECORD_TIMING_SNAP_EMERGENCY
                .replace("{{i}}", String.valueOf(i));
    }



    //LOW SPACE ALARM
    public static final String LOW_SPACE_ENABLE = "table.StorageLowSpace.Enable";
    public static final String LOW_SPACE_MAIL_ENABLE = "table.StorageLowSpace.EventHandler.MailEnable";
    public static final String LOW_SPACE_LOWER_LIMIT = "table.StorageLowSpace.LowerLimit";







    //STORAGE FAILURE
    public static final String STORAGE_FAILURE_ENABLE = "table.StorageFailure.Enable";
    public static final String STORAGE_FAILURE_MAIL_ENABLE = "table.StorageFailure.EventHandler.MailEnable";






    //STORAGE NOT EXIST
    public static final String STORAGE_NOT_EXIST_ENABLE = "table.StorageNotExist.Enable";
    public static final String STORAGE_NOT_EXIST_MAIL_ENABLE = "table.StorageNotExist.EventHandler.MailEnable";
    public static final String STORAGE_NOT_EXIST_SNAPSHOT = "table.StorageNotExist.EventHandler.Snapshot";







    //DEVICE-INFO
    public static String DEVICE_NAME = "list.info[{{i}}].Name";
    public static String getDeviceName(int index) {
        return DEVICE_NAME.replace("{{i}}", String.valueOf(index));
    }
    public static String DEVICE_STATE = "list.info[{{i}}].State";
    public static String getDeviceState(int index) {
        return DEVICE_STATE.replace("{{i}}", String.valueOf(index));
    }

    public static String DEVICE_PATH = "list.info[{{i}}].Detail[{{j}}].Path";
    public static String getDevicePath(int index, int j) {
        return DEVICE_PATH
                .replace("{{i}}", String.valueOf(index))
                .replace("{{j}}", String.valueOf(j));
    }
    public static String DEVICE_TOTAL_BYTES = "list.info[{{i}}].Detail[{{j}}].TotalBytes";
    public static String getDeviceTotalBytes(int index, int j) {
        return DEVICE_TOTAL_BYTES
                .replace("{{i}}", String.valueOf(index))
                .replace("{{j}}", String.valueOf(j));
    }
    public static String DEVICE_TYPE = "list.info[{{i}}].Detail[{{j}}].Type";
    public static String getDeviceType(int index, int j) {
        return DEVICE_TYPE
                .replace("{{i}}", String.valueOf(index))
                .replace("{{j}}", String.valueOf(j));
    }
    public static String DEVICE_USED_BYTES = "list.info[{{i}}].Detail[{{j}}].UsedBytes";
    public static String getDeviceUsedBytes(int index, int j) {
        return DEVICE_USED_BYTES
                .replace("{{i}}", String.valueOf(index))
                .replace("{{j}}", String.valueOf(j));
    }


}


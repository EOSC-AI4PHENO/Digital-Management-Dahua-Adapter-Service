package com.siseth.camera.dahua.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.siseth.camera.dahua.api.alarm.LowSpaceAlarmDTO;
import com.siseth.camera.dahua.api.alarm.StorageFailureAlarmDTO;
import com.siseth.camera.dahua.api.alarm.StorageNotExistAlarmDTO;
import com.siseth.camera.dahua.api.device.DeviceInfoDTO;
import com.siseth.camera.dahua.api.device.DeviceTypeDTO;
import com.siseth.camera.dahua.api.file.DahuaFilesDTO;
import com.siseth.camera.dahua.api.mediaEncode.MediaEncodeConfigDTO;
import com.siseth.camera.dahua.api.mediaEncode.SetMediaEncodeConfigDTO;
import com.siseth.camera.dahua.api.nas.NasConfigDTO;
import com.siseth.camera.dahua.api.nas.SetNasConfigDTO;
import com.siseth.camera.dahua.api.snap.SetSnapConfigDTO;
import com.siseth.camera.dahua.api.snap.SnapConfigDTO;
import com.siseth.camera.dahua.builder.DahuaParameterBuilder;
import com.siseth.camera.dahua.constant.DahuaConstant;
import com.siseth.camera.dahua.constant.DahuaUrl;
import com.siseth.camera.feign.dto.ImageSourceShortDTO;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.util.Map;

import static com.siseth.camera.dahua.builder.DahuaParameterBuilder.*;
import static com.siseth.camera.dahua.constant.DahuaConstant.*;
import static com.siseth.camera.dahua.constant.DahuaUrl.*;
import static com.siseth.camera.dahua.constant.DahuaUrl.DEVICE_TYPE_INFO;
import static com.siseth.camera.dahua.constant.DahuaUrl.LOCALES;

public class Dahua extends DahuaAbstract implements DahuaInterface{

    public Dahua(ImageSourceShortDTO sourceDTO) {
        this.username = sourceDTO.getCameraUser();
        this.password = sourceDTO.getCameraPassword();
        this.basicUrl = sourceDTO.getUrl() + ":" + sourceDTO.getPort() + "/cgi-bin/";
        valid();
    }

    public Dahua(String username, String password, String basicUrl) {
        this.username = username;
        this.password = password;
        this.basicUrl = basicUrl + "/cgi-bin/";
        valid();
    }
    @Override
    public String getCurrentDate() {
        this.url =  this.basicUrl + GET_CURRENT_TIME;
        return process().get(RESULT_DEFAULT);
    }

    @Override
    public String getTimezone() {
        this.url = this.basicUrl + DahuaGETBuilder().addName(NTP).build();
        return process().get(TIMEZONE_TAG);
    }

    @Override
    public String setTimezone(String timezone) {
        this.url = this.basicUrl + DahuaSETBuilder()
                .addParameter(TIMEZONE_SET, timezone)
                .build();
        return process().get(RESULT_DEFAULT);
    }

    @Override
    public String getDateTimeFormat() {
        this.url = this.basicUrl + DahuaGETBuilder().addName(LOCALES).build();
        return process().get(LOCALES_TAG);
    }

    @Override
    public String setDateFormat(String dateFormat) {
        this.url = this.basicUrl + DahuaSETBuilder()
                .addParameter(TIMEFORMAT_SET, dateFormat)
                .build();
        return process().get(RESULT_DEFAULT);
    }

    public String setDateTime(String dateTime) {
        this.url = this.basicUrl + DahuaSETTime()
                                            .addParameter(TIME, dateTime)
                                            .build();
        return process().get(RESULT_DEFAULT);
    }

    public DeviceInfoDTO getDeviceAllInfo() {
        this.url = this.basicUrl + DEVICE_ALL_INFO;
        Map<String, String> response = process();
        return new DeviceInfoDTO(response);
    }

    public DeviceTypeDTO getDeviceTypeInfo() {
        this.url = this.basicUrl + DEVICE_TYPE_INFO;
        Map<String, String> response = process();
        return new DeviceTypeDTO(response);
    }

    public String setDefaultConfig() {
        //Storage Group - Set
        Integer indexGroup = 2;
        Integer index = 0;

        this.url = this.basicUrl +
                DahuaSETBuilder()
                        .addParameter(setStorageGroupPicture(indexGroup), "%y-%M-%d/%c_%y%M%d%h%m%s_[%E][%O@%S][%R].jpg" )
                        .addParameter(setStorageGroupRecord(indexGroup), "%y-%M-%d/%h.%m.%s-%h.%m.%s[%E][%O@%S][%R].%t")

                        .addParameter(setRecordTimingLocal(index), "false")
                        .addParameter(setRecordTimingFTP(index), "true")

                        .addParameter(setRecordEventLocal(index), "false")
                        .addParameter(setRecordEventFTP(index), "false")
                        .addParameter(setRecordAlarmLocal(index), "false")
                        .addParameter(setRecordAlarmFTP(index), "true")

                        .addParameter(setRecordAlarmEmergency(index), "true")
                        .addParameter(setRecordEventEmergency(index), "true")
                        .addParameter(setRecordEventSnapEmergency(index), "true")
                        .addParameter(setRecordManualEmergency(index), "true")
                        .addParameter(setRecordTimingEmergency(index), "true")
                        .addParameter(setRecordManualSnapEmergency(index), "true")
                        .addParameter(setRecordTimingSnapEmergency(index), "true")


                        .build();
        //Storage Point - Set
        return process().get(RESULT_DEFAULT);
    }

    public void setNASConfig() {
    }

    @Override
    public NasConfigDTO getNASConfig() {
        this.url = this.basicUrl + DahuaGETBuilder().addName(NAS).build();
        return new NasConfigDTO(process());
    }

    public String setNASConfig(SetNasConfigDTO api) {
        Integer index = api.getIndex();
        this.url = this.basicUrl +
                DahuaSETBuilder()
                        .addParameter(setNasProtocol(index), api.getProtocol())
                        .addParameter(setNasAddress(index), api.getAddress())
                        .addParameter(setNasDirectory(index), api.getDirectory())
                        .addParameter(setNasEnable(index), api.getEnable())
                        .addParameter(setNasPort(index), api.getPort())
                        .addParameter(setNasPassword(index), api.getPassword())
                        .addParameter(setNasUser(index), api.getUser())
                        .build();
        return process().get(RESULT_DEFAULT);
    }

    public SnapConfigDTO getSnapConfig(String channel) {
        this.url = this.basicUrl + DahuaGETBuilder().addName(SNAP).build();
        Map<String, String> response = process();
        return new SnapConfigDTO(channel, response);
    }

    public String setSnapConfig(SetSnapConfigDTO api) {
        String channel = api.getChannel();
        DahuaParameterBuilder builder = DahuaSETBuilder();
        api.getSchedule().forEach(x -> builder.addParameter(setSnapSection(channel, x.getDayInt()), x.getData()));
        this.url = this.basicUrl + builder.build();
        return process().get(RESULT_DEFAULT);
    }

    @Override
    public MediaEncodeConfigDTO getEncodeMedia(String channel) {
        this.url = this.basicUrl + DahuaGETBuilder().addName(ENCODE).build();
        Map<String, String> response = process();
        return new MediaEncodeConfigDTO(response, channel);
    }

    public String setEncodeMedia(SetMediaEncodeConfigDTO api){
        String channel = api.getChannel();
        this.url = this.basicUrl + DahuaSETBuilder()
                .addParameter(setEncodeFPS(channel), api.getFps())
                .addParameter(setEncodeQuality(channel), api.getQuality())
                .build();
        return process().get(RESULT_DEFAULT);
    }


    public LowSpaceAlarmDTO getLowSpaceAlarmConfig() {
        this.url = basicUrl + DahuaGETBuilder().addName(LOW_SPACE_ALARM).build();
        Map<String, String> response = process();
        return new LowSpaceAlarmDTO(response);
    }

    public StorageFailureAlarmDTO getStorageFailureAlarmConfig() {
        this.url = basicUrl + DahuaGETBuilder().addName(STORAGE_FAILURE_ALARM).build();
        Map<String, String> response = process();
        return new StorageFailureAlarmDTO(response);
    }

    public StorageNotExistAlarmDTO getStorageNotExistsAlarmAlarmConfig() {
        this.url = basicUrl + DahuaGETBuilder().addName(STORAGE_NOT_EXIST_ALARM).build();
        Map<String, String> response = process();
        return new StorageNotExistAlarmDTO(response);
    }

    @SneakyThrows
    public byte[] getSnapshot(String channel) {
        this.url = this.basicUrl + SNAPSHOT + "?channel=" + channel;
        byte[] bytes = getBytes();
        return bytes;
    }

    @SneakyThrows
    @Override
    public File getFile(String name) {
        this.url = this.basicUrl + DahuaUrl.getFile(name);
        byte[] bytes = getBytes();
        File file = File.createTempFile("tmp", ".jpg");
        file.deleteOnExit();
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(bytes);
        fos.close();
        return file;
    }

    @Override
    @SneakyThrows
    public DahuaFilesDTO getFiles(String dir, String from, String to, String channel) {
        //STEP 1 CREATE FINDER
        this.url = this.basicUrl + MEDIA_FINDER_STEP_1;
        String res = process().getOrDefault(RESULT_DEFAULT,"");
        if(res.equals(""))
            throw new RuntimeException("Error in getFiles() in step 1");
        //STEP 2 FIND BY CRITERIA
        this.url = this.basicUrl +
                DahuaParameterBuilder.DahuaMediaFinder()
                        .addParameter(OBJECT, res)
                        .addParameter(COND_DIR, dir)
                        .addParameter(COND_START, from)
                        .addParameter(COND_END, to)
                        .addParameter(COND_CHANNEL, channel)
                        .build();
        if(process().getOrDefault(RESULT_DEFAULT,"").equals(""))
            throw new RuntimeException("Error in getFiles() in step 2");
        this.url = this.basicUrl + DahuaParameterBuilder.DahuaMediaGetFile()
                .addParameter(OBJECT, res)
                .addParameter(COUNT, "1000")
                .build();
        Map<String, String> response = process();
        DahuaFilesDTO result = new DahuaFilesDTO(response);
        //STEP 4 CLOSE FINDER
        this.url = this.basicUrl + MEDIA_FINDER_STEP_4 + res;
        if(process().getOrDefault(RESULT_DEFAULT,"").equals(""))
            throw new RuntimeException("Error in getFiles() in step 4");
        this.url = this.basicUrl + MEDIA_FINDER_STEP_5 + res;
        if(process().getOrDefault(RESULT_DEFAULT,"").equals(""))
            throw new RuntimeException("Error in getFiles() in step 5");
        return result;


    }


}

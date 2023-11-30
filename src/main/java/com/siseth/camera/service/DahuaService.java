package com.siseth.camera.service;

import com.siseth.camera.dahua.api.alarm.LowSpaceAlarmDTO;
import com.siseth.camera.dahua.api.alarm.StorageFailureAlarmDTO;
import com.siseth.camera.dahua.api.alarm.StorageNotExistAlarmDTO;
import com.siseth.camera.dahua.api.datetime.DateTimeConfigDTO;
import com.siseth.camera.dahua.api.datetime.SetDateTimeConfigDTO;
import com.siseth.camera.dahua.api.device.DeviceInfoDTO;
import com.siseth.camera.dahua.api.device.DeviceTypeDTO;
import com.siseth.camera.dahua.api.file.DahuaFilesDTO;
import com.siseth.camera.dahua.api.mediaEncode.MediaEncodeConfigDTO;
import com.siseth.camera.dahua.api.mediaEncode.SetMediaEncodeConfigDTO;
import com.siseth.camera.dahua.api.nas.NasConfigDTO;
import com.siseth.camera.dahua.api.nas.SetNasConfigDTO;
import com.siseth.camera.dahua.api.snap.SetSnapConfigDTO;
import com.siseth.camera.dahua.api.snap.SnapConfigDTO;
import com.siseth.camera.dahua.model.Dahua;
import com.siseth.camera.feign.SourceAdapterService;
import com.siseth.camera.feign.dto.ImageSourceShortDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DahuaService {

    private final SourceAdapterService adapterService;


    //___________________________________________

    public DateTimeConfigDTO getDateTimeConfig(Long sourceId) {
        Dahua dahua = new Dahua(get(sourceId));
        return new DateTimeConfigDTO(
                dahua.getCurrentDate(),
                dahua.getTimezone(),
                dahua.getDateTimeFormat()
        );
    }

    public void setDateTimeConfig(Long sourceId, SetDateTimeConfigDTO api) {
        Dahua dahua = new Dahua(get(sourceId));
        Optional.ofNullable(api.getDateTime()).ifPresent(dahua::setDateTime);
        Optional.ofNullable(api.getTimezone()).ifPresent(dahua::setTimezone);
        Optional.ofNullable(api.getDateTimeFormat()).ifPresent(dahua::setDateFormat);
    }

    public String getTime(Long sourceId) {
        return new Dahua(get(sourceId)).getCurrentDate();
    }
    public String setTime(Long sourceId, String dateTime) {
        return new Dahua(get(sourceId)).setDateTime(dateTime);
    }

    public String getTimezone(Long sourceId) {
        return new Dahua(get(sourceId)).getTimezone();
    }

    public String setTimezone(Long sourceId, String timezone) {
        return new Dahua(get(sourceId)).setTimezone(timezone);
    }

    //___________________________________________
    public SnapConfigDTO getSnapConfig(Long sourceId, String channel) {
        return new Dahua(get(sourceId)).getSnapConfig(channel);
    }

    public String setSnapConfig(Long sourceId, SetSnapConfigDTO setSnapConfigDTO){
        String response = new Dahua(get(sourceId)).setSnapConfig(setSnapConfigDTO);
        adapterService.updateSnapConfig(sourceId, setSnapConfigDTO.getDaysString());
        return response;
    }

    public byte[] getSnapshot(Long sourceId, String channel){
        byte[] bytes = new Dahua(get(sourceId)).getSnapshot(channel);
        if(bytes == null || bytes.length == 0)
            throw new RuntimeException("Error when create a snaphot");
        return bytes;
    }

    //___________________________________________
    public NasConfigDTO getNASConfig(Long sourceId) {
        return new Dahua(get(sourceId)).getNASConfig();
    }

    public String setNASConfig(Long sourceId, SetNasConfigDTO setNasConfig) {
        return new Dahua(get(sourceId)).setNASConfig(setNasConfig);
    }

    public MediaEncodeConfigDTO getEncodeMedia(Long sourceId, String channel) {
        return new Dahua(get(sourceId)).getEncodeMedia(channel);
    }

    public String setEncodeMedia(Long sourceId, SetMediaEncodeConfigDTO api) {
        return new Dahua(get(sourceId)).setEncodeMedia(api);
    }

    //---------------------------------------------------------------------

    public File getFile(Long sourceId, String filename) {
        return new Dahua(get(sourceId)).getFile(filename);
    }

    public DahuaFilesDTO getFiles(Long sourceId, String dir,
                                  String from, String to,
                                  String channel) {
        return new Dahua(get(sourceId)).getFiles(dir, from, to, channel);
    }


    //--------------------------------------------------------------------
    public DeviceInfoDTO getDeviceAllInfo(Long sourceId) {
        return new Dahua(get(sourceId)).getDeviceAllInfo();
    }

    public DeviceTypeDTO getDeviceTypeInfo(Long sourceId) {
        return new Dahua(get(sourceId)).getDeviceTypeInfo();
    }

    //----------------------------------------------------------------

    public LowSpaceAlarmDTO getLowSpaceAlarmConfig(Long sourceId) {
        return new Dahua(get(sourceId)).getLowSpaceAlarmConfig();
    }

    public StorageFailureAlarmDTO getStorageFailureAlarmConfig(Long sourceId) {
        return new Dahua(get(sourceId)).getStorageFailureAlarmConfig();
    }

    public StorageNotExistAlarmDTO getStorageNotExistsAlarmAlarmConfig(Long sourceId) {
        return new Dahua(get(sourceId)).getStorageNotExistsAlarmAlarmConfig();
    }

    //____________________________________________________________________
    private ImageSourceShortDTO get(Long sourceId) {
        return adapterService.getSource(sourceId);
    }

}

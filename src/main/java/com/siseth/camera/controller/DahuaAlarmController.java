package com.siseth.camera.controller;

import com.siseth.camera.dahua.api.alarm.LowSpaceAlarmDTO;
import com.siseth.camera.dahua.api.alarm.StorageFailureAlarmDTO;
import com.siseth.camera.dahua.api.alarm.StorageNotExistAlarmDTO;
import com.siseth.camera.dahua.model.Dahua;
import com.siseth.camera.service.DahuaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/digital/dahua/alarm")
@Tag(name = "Dahua Alarm Controller", description = "Endpoints to get config of alarm")
@RequiredArgsConstructor
public class DahuaAlarmController {

    private final DahuaService service;

    @GetMapping("/{sourceId}/low-space")
    @Operation(summary = "Get Storage Low Space Event Config")
    public ResponseEntity<LowSpaceAlarmDTO> getLowSpaceAlarm(@PathVariable Long sourceId){
        return ResponseEntity.ok(service.getLowSpaceAlarmConfig(sourceId));
    }


    @GetMapping("/{sourceId}/storage-failure")
    @Operation(summary = "Get Storage Failure Event Config")
    public ResponseEntity<StorageFailureAlarmDTO> getStorageFailureAlarm(@PathVariable Long sourceId){
        return ResponseEntity.ok(service.getStorageFailureAlarmConfig(sourceId));
    }

    @GetMapping("/{sourceId}/storage-not-exist")
    @Operation(summary = "Get Storage Not Exist Event Config")
    public ResponseEntity<StorageNotExistAlarmDTO> getStorageNotExistsAlarmConfig(@PathVariable Long sourceId){
        return ResponseEntity.ok(service.getStorageNotExistsAlarmAlarmConfig(sourceId));
    }


}


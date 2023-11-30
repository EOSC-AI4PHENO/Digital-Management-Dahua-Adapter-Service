package com.siseth.camera.controller;

import com.siseth.camera.dahua.api.device.DeviceInfoDTO;
import com.siseth.camera.dahua.api.device.DeviceTypeDTO;
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
@RequestMapping("/api/digital/dahua/device")
@Tag(name = "Dahua Device Controller", description = "Endpoints to get config of device")
@RequiredArgsConstructor
public class DahuaDeviceController {

    private final DahuaService service;

    @GetMapping("/{sourceId}/info")
    @Operation(summary = "Get basic info about devices")
    public ResponseEntity<DeviceInfoDTO> getDeviceAllInfo(@PathVariable Long sourceId){
        return ResponseEntity.ok(service.getDeviceAllInfo(sourceId));
    }

    @GetMapping("/{sourceId}/type")
    @Operation(summary = "Get basic info about camera (serial number, device type, version)")
    public ResponseEntity<DeviceTypeDTO> getDeviceTypeInfo(@PathVariable Long sourceId){
        return ResponseEntity.ok(service.getDeviceTypeInfo(sourceId));
    }

}

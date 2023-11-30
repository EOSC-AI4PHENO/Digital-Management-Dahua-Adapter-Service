package com.siseth.camera.controller;

import com.siseth.camera.dahua.api.snap.SetSnapConfigDTO;
import com.siseth.camera.dahua.api.snap.SnapConfigDTO;
import com.siseth.camera.dahua.model.Dahua;
import com.siseth.camera.service.DahuaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

@RestController
@RequestMapping("/api/digital/dahua/snapshot")
@Tag(name = "Dahua Snapshot Controller", description = "Endpoints to get current snapshot and get/set snap config")
@RequiredArgsConstructor
public class DahuaSnapshotController {

    private final DahuaService service;

    @GetMapping("/snap/{sourceId}")
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Get SNAP config", description = "Data about schedule")
    public ResponseEntity<SnapConfigDTO> getSnapConfig(@PathVariable Long sourceId,
                                                       @RequestParam(defaultValue = "0") String channel){
        return ResponseEntity.ok(service.getSnapConfig(sourceId, channel));
    }

    @PutMapping("/snap/{sourceId}")
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Set SNAP config", description = "Data about schedule")
    public ResponseEntity<?> setSnapConfig(@PathVariable Long sourceId,
                                           @RequestBody SetSnapConfigDTO setSnapConfigDTO){
        return ResponseEntity.ok(service.setSnapConfig(sourceId, setSnapConfigDTO));
    }

    @PutMapping("/snap/{sourceId}/default")
    @SecurityRequirement(name = "Bearer Authentication")
    @SneakyThrows
    @Operation(summary = "Set SNAP config default", description = "Data about schedule")
    public ResponseEntity<?> setSnapConfigDefault(@PathVariable Long sourceId){
        
        return ResponseEntity.ok(service.setSnapConfig(sourceId, new SetSnapConfigDTO()));
    }


    @GetMapping("/snap/{sourceId}/get")
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Get Current snapshot")
    public ResponseEntity<?> getCurrentSnapshot(@PathVariable Long sourceId,
                                                   HttpServletResponse response,
                                                   @RequestParam(defaultValue = "1") String channel){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return ResponseEntity.ok().headers(headers)
                .body(service.getSnapshot(sourceId, channel));
    }

}

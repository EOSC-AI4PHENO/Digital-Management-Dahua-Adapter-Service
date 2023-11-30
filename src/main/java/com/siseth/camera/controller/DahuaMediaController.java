package com.siseth.camera.controller;

import com.siseth.camera.dahua.api.mediaEncode.MediaEncodeConfigDTO;
import com.siseth.camera.dahua.api.mediaEncode.SetMediaEncodeConfigDTO;
import com.siseth.camera.dahua.api.nas.NasConfigDTO;
import com.siseth.camera.dahua.api.nas.SetNasConfigDTO;
import com.siseth.camera.dahua.model.Dahua;
import com.siseth.camera.service.DahuaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/digital/dahua/media")
@Tag(name = "Dahua Media Controller", description = "Endpoints to configure FTP and media encode ")
@RequiredArgsConstructor
public class DahuaMediaController {

    private final DahuaService service;
    @GetMapping("/nas/{sourceId}")
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Get FTP data", description = "Get data about FTP (address, directory, port, user, isEnable)")
    public ResponseEntity<NasConfigDTO> getNAS(@PathVariable Long sourceId){
        return ResponseEntity.ok(service.getNASConfig(sourceId));
    }


    @PutMapping("/nas/{sourceId}")
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Set FTP data", description = "Data: address, directory, port, user, isEnable ")
    public ResponseEntity<String> setMediaEncode(@PathVariable Long sourceId,
                                                 @RequestBody SetNasConfigDTO setNasConfig){
        return ResponseEntity.ok(service.setNASConfig(sourceId, setNasConfig));
    }


    @GetMapping("/media-encode/{sourceId}")
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Get media config", description = "Data: FPS, Quality of Picture, Quality Range")
    public ResponseEntity<MediaEncodeConfigDTO> getMediaEncode(@PathVariable Long sourceId,
                                                               @RequestParam(defaultValue = "0") String channel){
        return ResponseEntity.ok(service.getEncodeMedia(sourceId, channel));
    }

    @PutMapping("/media-encode/{sourceId}")
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Set media config", description = "Data: FPS, Quality of Picture")
    public ResponseEntity<?> setMediaEncode(@PathVariable Long sourceId,
                                            @RequestBody SetMediaEncodeConfigDTO setMediaEncodeConfig){
        return ResponseEntity.ok(service.setEncodeMedia(sourceId, setMediaEncodeConfig));
    }

    @PutMapping("/media-encode/{sourceId}/default")
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Set media config default", description = "Data: FPS, Quality of Picture")
    public ResponseEntity<?> setMediaEncodeDefault(@PathVariable Long sourceId){
        return ResponseEntity.ok(service.setEncodeMedia(sourceId, new SetMediaEncodeConfigDTO()));
    }

}

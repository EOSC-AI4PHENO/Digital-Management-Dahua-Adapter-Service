package com.siseth.camera.controller;

import com.siseth.camera.dahua.api.file.DahuaFilesDTO;
import com.siseth.camera.dahua.model.Dahua;
import com.siseth.camera.service.DahuaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;

@RestController
@RequestMapping("/api/digital/dahua/files")
@Tag(name = "Dahua File Controller", description = "Endpoints to get files list and download picture")
@RequiredArgsConstructor
public class DahuaFileController {

    private final DahuaService service;

    @PostMapping("{sourceId}/download")
    @SneakyThrows
    @Operation(summary = "Download file from Dahua", description = "Returned object is java.io.File object")
    public ResponseEntity<?> download(@PathVariable Long sourceId,
                                      @RequestParam String filename){
        File file = service.getFile(sourceId, filename);
        return ResponseEntity.ok()
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(new FileInputStream(file)));
    }

    @GetMapping("{sourceId}")
    @Operation(summary = "Get list of files from Dahua")
    public ResponseEntity<DahuaFilesDTO> getFiles(@PathVariable Long sourceId,
                                                  @RequestParam(required = false) String dir,
                                                  @RequestParam String from,
                                                  @RequestParam String to,
                                                  @RequestParam(defaultValue = "1") String channel){
        return ResponseEntity.ok(service.getFiles(sourceId, dir, from, to, channel));
    }

}


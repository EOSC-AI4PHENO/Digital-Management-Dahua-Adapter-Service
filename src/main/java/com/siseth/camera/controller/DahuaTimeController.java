package com.siseth.camera.controller;

import com.siseth.camera.dahua.api.datetime.DateTimeConfigDTO;
import com.siseth.camera.dahua.api.datetime.SetDateTimeConfigDTO;
import com.siseth.camera.dahua.model.Dahua;
import com.siseth.camera.service.DahuaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/digital/dahua/time")
@Tag(name = "Dahua Time Controller", description = "Endpoints to actual time and timezone")
@RequiredArgsConstructor
public class DahuaTimeController {

    private final DahuaService service;

    //
    @GetMapping("/{sourceId}/all")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<DateTimeConfigDTO> getAllTimeConfig(@PathVariable Long sourceId){
        return ResponseEntity.ok(service.getDateTimeConfig(sourceId));
    }

   @PutMapping("/{sourceId}/all")
   @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<Void> setAllTimeConfig(@PathVariable Long sourceId,
                                                   @RequestBody SetDateTimeConfigDTO setDateTimeConfigDTO){
        service.setDateTimeConfig(sourceId, setDateTimeConfigDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{sourceId}/default")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<Void> setDefault(@PathVariable Long sourceId){
        service.setDateTimeConfig(sourceId, new SetDateTimeConfigDTO());
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Get current Datetime from Dahua", description = "Date as a String, in format yyyy-mm-dd hh:mm")
    @GetMapping("/{sourceId}")
    public ResponseEntity<String> getTime(@PathVariable Long sourceId){
        return ResponseEntity.ok(service.getTime(sourceId));
    }

    @Operation(summary = "Set current Datetime in Dahua", description = "Date as a String, in format yyyy-mm-dd hh:mm")
    @PostMapping("/{sourceId}")
    public ResponseEntity<String> setTime(@PathVariable Long sourceId, @RequestParam String dateTime){
        return ResponseEntity.ok(service.setTime(sourceId, dateTime));
    }

    @GetMapping("/timezone/{sourceId}")
    @Operation(summary = "Get current timezone")
    public ResponseEntity<?> getTimezone(@PathVariable Long sourceId){
        return ResponseEntity.ok(service.getTimezone(sourceId));
    }

    @PostMapping("/timezone/{sourceId}")
    @Operation(summary = "Set timezone in Dahua")
    public ResponseEntity<?> setTimezone(@PathVariable Long sourceId,
                                         @RequestParam String timezone){
        return ResponseEntity.ok(service.setTimezone(sourceId, timezone));
    }

}

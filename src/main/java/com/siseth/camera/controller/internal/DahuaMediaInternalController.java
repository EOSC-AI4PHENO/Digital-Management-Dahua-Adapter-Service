package com.siseth.camera.controller.internal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.siseth.camera.dahua.api.mediaEncode.MediaEncodeConfigDTO;
import com.siseth.camera.dahua.api.nas.NasConfigDTO;
import com.siseth.camera.dahua.api.nas.SetNasConfigDTO;
import com.siseth.camera.dahua.model.Dahua;
import io.swagger.v3.oas.annotations.Operation;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/internal/dahua/media")
public class DahuaMediaInternalController {


    @PutMapping("/nas")
    @SneakyThrows
    public ResponseEntity<String> setMediaEncode(@RequestParam String ip,
                                                 @RequestParam String port,
                                                 @RequestParam String user,
                                                 @RequestParam String pass,
                                                 @RequestBody SetNasConfigDTO api){
        String url = ip + ":" + port;
        Dahua dahua = new Dahua(user, pass, url);
        return ResponseEntity.ok(dahua.setNASConfig(api));
    }

    @GetMapping("/nas")
    @SneakyThrows
    public ResponseEntity<NasConfigDTO> getMediaEncode(@RequestParam String ip,
                                                       @RequestParam String port,
                                                       @RequestParam String user,
                                                       @RequestParam String pass){
        String url = ip + ":" + port;
        Dahua dahua = new Dahua(user, pass, url);
        return ResponseEntity.ok(dahua.getNASConfig());
    }

}

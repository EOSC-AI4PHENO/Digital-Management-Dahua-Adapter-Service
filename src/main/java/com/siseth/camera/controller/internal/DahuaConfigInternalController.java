package com.siseth.camera.controller.internal;

import com.siseth.camera.dahua.api.device.DeviceTypeDTO;
import com.siseth.camera.dahua.model.Dahua;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/internal/dahua/config")
public class DahuaConfigInternalController {

    @PostMapping("/default")
    public ResponseEntity<String> setDefaultConfig(@RequestParam String ip,
                                                          @RequestParam String port,
                                                          @RequestParam String user,
                                                          @RequestParam String pass){
        String url = ip + ":" + port;
        Dahua dahua = new Dahua(user, pass, url);
        return ResponseEntity.ok(dahua.setDefaultConfig());
    }

}

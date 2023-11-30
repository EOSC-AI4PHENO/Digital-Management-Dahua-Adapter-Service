package com.siseth.camera.controller.internal;

import com.siseth.camera.dahua.api.device.DeviceInfoDTO;
import com.siseth.camera.dahua.api.device.DeviceTypeDTO;
import com.siseth.camera.dahua.model.Dahua;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/internal/dahua/device")
public class DahuaDeviceInternalController {

    @GetMapping("/type")
    public ResponseEntity<DeviceTypeDTO> getDeviceTypeInfo(@RequestParam String ip,
                                                           @RequestParam String port,
                                                           @RequestParam String user,
                                                           @RequestParam String pass){
        String url = ip + ":" + port;
        Dahua dahua = new Dahua(user, pass, url);
        return ResponseEntity.ok(dahua.getDeviceTypeInfo());
    }

    @GetMapping("/info")
    public ResponseEntity<?> getDeviceAllInfo(@RequestParam String ip,
                                                          @RequestParam String port,
                                                          @RequestParam String user,
                                                          @RequestParam String pass){
        String url = ip + ":" + port;
        Dahua dahua = new Dahua(user, pass, url);
        return ResponseEntity.ok(dahua.getDeviceAllInfo().getItems());
    }

}

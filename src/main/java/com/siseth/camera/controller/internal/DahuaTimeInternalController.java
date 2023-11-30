package com.siseth.camera.controller.internal;

import com.siseth.camera.dahua.model.Dahua;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/internal/dahua/time")
public class DahuaTimeInternalController {
    @GetMapping("/timezone")
    public ResponseEntity<String> getTimezone(@RequestParam String ip,
                                              @RequestParam String port,
                                              @RequestParam String user,
                                              @RequestParam String pass){
        String url = ip + ":" + port;
        Dahua dahua = new Dahua(user, pass, url);
        return ResponseEntity.ok(dahua.getTimezone());
    }

    @GetMapping
    public ResponseEntity<String> getCurrentDate(@RequestParam String ip,
                                                  @RequestParam String port,
                                                  @RequestParam String user,
                                                  @RequestParam String pass){
        String url = ip + ":" + port;
        Dahua dahua = new Dahua(user, pass, url);
        return ResponseEntity.ok(dahua.getCurrentDate());
    }

    @PostMapping("/timezone")
    public ResponseEntity<?> setTimezone(@RequestParam String ip,
                                         @RequestParam String port,
                                         @RequestParam String user,
                                         @RequestParam String pass,
                                         @RequestParam String timezone){
        String url = ip + ":" + port;
        Dahua dahua = new Dahua(user, pass, url);
        return ResponseEntity.ok(dahua.setTimezone(timezone));
    }

}

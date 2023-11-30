package com.siseth.camera.feign;

import com.siseth.camera.feign.dto.ImageSourceShortDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "source-adapter-service")
public interface SourceAdapterService {

    @GetMapping("/api/internal/digital/source-adapter/{id}")
    public ImageSourceShortDTO getSource(@PathVariable Long id);

    @PutMapping("api/internal/digital/source-adapter/{id}/snapconfig")
    void updateSnapConfig(@PathVariable Long id, @RequestParam String days);
}

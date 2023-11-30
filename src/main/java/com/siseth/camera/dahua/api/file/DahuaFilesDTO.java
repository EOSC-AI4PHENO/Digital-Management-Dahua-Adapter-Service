package com.siseth.camera.dahua.api.file;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.siseth.camera.dahua.constant.DahuaConstant.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DahuaFilesDTO {

    private List<DahuaFileDTO> files;

    private Integer count;

    private String lastStartTime;

    public DahuaFilesDTO(Map<String, String> map) {
        int i = 0;
        this.files = new ArrayList<>();
        while(map.get(getFilePath(i)) != null ){
            if(map.get(getFileType(i)) != null && map.get(getFileType(i)).equals("jpg") && map.get(getWorkDir(i)).startsWith("/mnt/"))
                this.files.add(
                        new DahuaFileDTO(
                                map.get(getFilePath(i)),
                                map.get(getFileStart(i)),
                                map.get(getFileLength(i)),
                                map.get(getFileType(i))
                        )
                );
            i++;
        }
        this.count = i;
        this.lastStartTime = map.get(getFileStart(i -1));
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public class DahuaFileDTO {

        private String filePath;

        private String startTime;
//
        private String length;
//
        private String type;

    }

}

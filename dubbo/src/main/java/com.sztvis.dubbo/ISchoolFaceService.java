package com.sztvis.dubbo;


import com.sztvis.domain.domain.TramDriverSimilarRecord;
import com.sztvis.domain.dto.SchoolFaceViewModel;

import java.util.List;

/**
 * 校车人脸识别
 */
public interface ISchoolFaceService {
    /**
     * 增加识别记录
     * @param record
     */
    void insertDriverSimilarRecord(TramDriverSimilarRecord record);

    List<SchoolFaceViewModel> getSchoolFaceList(String name, int page, int rows);

    int getSchoolFaceCountList(String name);

    void updateSchoolFaceImage(String image, String deviceCode, String updateTime);
}

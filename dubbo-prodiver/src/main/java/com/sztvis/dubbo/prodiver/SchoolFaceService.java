package com.sztvis.dubbo.prodiver;

import com.alibaba.dubbo.config.annotation.Service;
import com.sztvis.domain.domain.TramDriverSimilarRecord;
import com.sztvis.domain.dto.SchoolFaceViewModel;
import com.sztvis.dubbo.ISchoolFaceService;
import com.sztvis.dubbo.prodiver.mapper.SchoolFaceMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(version = "1.0.0")
public class SchoolFaceService implements ISchoolFaceService {

    @Autowired
    private SchoolFaceMapper schoolFaceMapper;

    @Override
    public void insertDriverSimilarRecord(TramDriverSimilarRecord record) {
        this.schoolFaceMapper.insertDriverSimilarRecord(record);
    }

    @Override
    public List<SchoolFaceViewModel> getSchoolFaceList(String name, int page, int rows) {
        return this.schoolFaceMapper.getSchoolFaceList(name,page,rows);
    }

    @Override
    public int getSchoolFaceCountList(String name) {
        return this.schoolFaceMapper.getSchoolFaceCount(name);
    }

    @Override
    public void updateSchoolFaceImage(String image, String deviceCode, String updateTime) {
        this.schoolFaceMapper.updateSchoolFaceImage(image,deviceCode,updateTime);
    }
}

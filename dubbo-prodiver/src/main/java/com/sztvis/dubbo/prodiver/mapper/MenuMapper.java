package com.sztvis.dubbo.prodiver.mapper;

import com.sztvis.domain.domain.TramMenuInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author longweiqian
 * @company tvis
 * @date 2017/12/29 下午1:36
 */
@Repository
public interface MenuMapper {

    @Select("select * from tramMenuInfo where parentId=#{parentId} order by OrderBy asc")
    List<TramMenuInfo> GetMenus(@Param("parentId") long parentId);
}

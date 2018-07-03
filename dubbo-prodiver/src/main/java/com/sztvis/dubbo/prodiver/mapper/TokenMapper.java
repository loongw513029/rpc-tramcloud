package com.sztvis.dubbo.prodiver.mapper;

import com.sztvis.domain.domain.V3TokenInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/2/7 下午4:04
 */
public interface TokenMapper {

    @Insert("insert into V3TokenInfo(departmentcode,accesstoken,refreshtoken,expiresin)values(#{departmentcoode},#{accesstoken},#{refreshtoken},#{expiresin})")
    void insertTokenInfo(V3TokenInfo tokenInfo);

    @Select("select * from V3TokenInfo where departmentcode=#{departmentcode}")
    V3TokenInfo getTokenInfo(String departmentcode);

    @Update("update V3TokenInfo set accesstoken=#{accesstoken} where departmentcode=#{departmentcode} and refreshtoken=#{refershtoken}")
    void UpdateAccessToken(@Param("accesstoken") String accesstoken, @Param("departmentcode") String departmentcode, @Param("refreshtoken") String refreshtoken);

}

package com.sztvis.dubbo.prodiver.mapper.provider;

import com.sztvis.core.helper.StringHelper;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/17 下午5:41
 */
public class MemberProvider {

    public String getUserListSQL(Map<String,Object> map){
        String departmentIds = (String)map.get("departmentIds");
        List<Integer> departments = (List<Integer>)map.get("departments");
        String username = (String)map.get("username");
        String sql = "select a.id,a.username,b.departmentname,c.rolename,a.realname,a.phone,a.status,a.createtime from ";
        sql+="TramMemberInfo a left join TramDepartmentInfo b on a.ownershipid = b.id left join TramRoleInfo c on a.roleid = c.id where a.ownershipid in ("+StringHelper.listToString(departments,',')+")";
        if(!StringHelper.isEmpty(departmentIds)){
            sql+=" and a.ownershipId in ("+departmentIds+")";
        }
        if(!StringHelper.isEmpty(username))
            sql+=" and a.username like '%"+username+"%' or a.realname like '%"+username+"%'";
        return  sql;
    }

    public String getMemberGuidByDepartmentIds(Map<String,Object> map){
        List<Long> departmentIds = (List<Long>) map.get("departments");
        SQL sql = new SQL();
        sql.SELECT("Guid")
                .FROM("TramMemberInfo")
                .WHERE("ownershipId in ("+StringHelper.listToString(departmentIds,',')+")");
        return sql.toString();
    }
}

package com.sztvis.dubbo.prodiver.mapper.provider;


import com.sztvis.core.helper.StringHelper;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class BuildFaceProvider {
    public String getBuildFaceListSQL(Map<String,Object> map){
        List<Long> departments = (List<Long>)map.get("departments");
        String keyword = (String)map.get("keyword");
        long departmentId = (Long)map.get("departmentId");
        int sex = (Integer)map.get("sex");
        int page = (Integer)map.get("page");
        int rows = (Integer)map.get("rows");
        SQL sql = new SQL();
        sql.SELECT("a.*,GROUP_CONCAT(b.filepath) as images,c.departmentname");
        sql.FROM("TramPersonInfo a left join TramPersonPics b on a.id=b.personid left join TramDepartmentInfo c on a.departmentId = c.id");
        String where="a.departmentId in ("+ StringHelper.listToString(departments,',')+")";
        if(sex!=-1){
            where+=" and a.sex="+sex;
        }
        if(departmentId!=0){
            where+=" and a.departmentId="+departmentId;
        }
        if(!StringHelper.isEmpty(keyword)){
            where+=" and (a.name like '"+keyword+"' or a.oldname like '"+keyword+"')";
        }
        sql.WHERE(where);
        sql.GROUP_BY("b.filepath");
        sql.ORDER_BY("a.createtime desc");
        String sql2 =sql.toString()+" limit "+(page-1)*rows+","+rows;
        return sql2;
    }

    public String getBuildFaceListCountSQL(Map<String,Object> map){
        List<Long> departments = (List<Long>)map.get("departments");
        String keyword = (String)map.get("keyword");
        long departmentId = (Long)map.get("departmentId");
        int sex = (Integer)map.get("sex");
        SQL sql = new SQL();
        sql.SELECT("count(id)");
        sql.FROM("TramPersonInfo");
        String where="departmentId in ("+StringHelper.listToString(departments,',')+")";
        if(sex!=-1){
            where+=" and sex="+sex;
        }
        if(departmentId!=0){
            where+=" and departmentId="+departmentId;
        }
        if(!StringHelper.isEmpty(keyword)){
            where+=" and (name like '"+keyword+"' or oldname like '"+keyword+"')";
        }
        sql.WHERE(where);
        return sql.toString();
    }
}

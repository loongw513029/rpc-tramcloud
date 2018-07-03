package com.sztvis.dubbo.prodiver.mapper.provider;

import com.sztvis.core.helper.StringHelper;
import com.sztvis.domain.domain.TramMemberInfo;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/18 下午2:19
 */
public class LineProvider {
    

    public String getListSQL(Map<String,Object> map){
        List<Long> departments = (List<Long>)map.get("departments");
        String lineName = (String)map.get("linename");
        Long seldepartmentId = (Long)map.get("departmentId");
        String sql= "select a.id,a.linecode,a.linename,b.departmentname,a.lineupmileage,a.linedownmileage,a.upsitenum,a.downsitenum";
        sql+=" from TramLineInfo a left join TramDepartmentInfo b on a.departmentid = b.id  where a.departmentId in("+ StringHelper.listToString(departments,',')+")";
        if(!StringHelper.isEmpty(lineName)){
            sql+=" and (a.linename like '%"+lineName+"%' or a.linecode like '%"+lineName+"%')";
        }
        if(seldepartmentId!=0){
            sql+=" and a.departmentId="+seldepartmentId;
        }
        sql+=" order by a.sort asc";
        return sql;
    }

    public String getLineTreeSQL(Map<String,Object> map){
        String departments = StringHelper.listToString(((List<Long>)map.get("departments")),',');
        String sql = "select id,linename as text from TramLineInfo where departmentId in ("+departments+")";
        return  sql;
    }

    public String getDropDownLineSQL(TramMemberInfo user, int type, List<Long> arr, String msg)
    {
        String OrganizationIds=arr.toString().replace("[", "(").replace("]",")");
        SQL sql=new SQL();
        if(type!=3)
            sql.SELECT("Id,LineName as Value");
        else
            sql.SELECT("Id");
        sql.FROM("TramLineInfo");
        if(type==2)
            sql.WHERE("DepartmentId in"+ OrganizationIds +"");
        if(type==3)
            sql.WHERE("Id in "+ msg +"");
        sql.ORDER_BY("sort asc");
        return sql.toString();
    }
    //select count(Id) from TramLineInfo where departmentId in #{departmentId}

    public String getLineIdsByDepartmentIdsSQL(Map<String,Object> map){
        List<Long> departmentId =(List<Long>)map.get("departmentId");
        SQL sql = new SQL();
        sql.SELECT("count(Id)");
        sql.FROM("TramLineInfo");
        sql.WHERE("departmentId in ("+StringHelper.listToString(departmentId,',')+")");
        return sql.toString();
    }
}

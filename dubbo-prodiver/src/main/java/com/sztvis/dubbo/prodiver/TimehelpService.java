package com.sztvis.dubbo.prodiver;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class TimehelpService {
    public String getSomeDay(Date date, int day,String layout){
         Calendar calendar = Calendar.getInstance();
         calendar.setTime(date);
         calendar.add(Calendar.DATE, day);
        SimpleDateFormat df = new SimpleDateFormat(layout);
         return df.format(calendar.getTime());
     }
}

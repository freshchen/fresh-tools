package com.github.freshchen.javatools.util;

import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: fresh-tools
 * @Date: 2019/9/21 10:51
 * @Author: Ling Chen
 * @Description:
 */
@Component
public class MyUtils {

    public Map getDate(long timestamp) {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Instant instant = Instant.ofEpochMilli(timestamp);
        String defaultTime = ZonedDateTime.ofInstant(instant, ZoneId.systemDefault()).format(timeFormatter);
        String utc = ZonedDateTime.ofInstant(instant, ZoneId.of("UTC")).format(timeFormatter);
        String shangHai = ZonedDateTime.ofInstant(instant, ZoneId.of("Asia/Shanghai")).format(timeFormatter);
        String chicago = ZonedDateTime.ofInstant(instant, ZoneId.of("Asia/Shanghai")).format(timeFormatter);
        Map <String, String> times = new HashMap <>();
        times.put("System Defult-" + ZoneId.systemDefault().getId(), defaultTime);
        times.put("UTC", utc);
        times.put("CTT-Asia/Shanghai", shangHai);
        times.put("CST-America/Chicago", chicago);
        return times;
    }

}

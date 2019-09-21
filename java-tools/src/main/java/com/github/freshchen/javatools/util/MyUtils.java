package com.github.freshchen.javatools.util;

import com.github.freshchen.javatools.common.constant.StrConstants;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: fresh-tools
 * @Date: 2019/9/21 10:51
 * @Author: Ling Chen
 * @Description:
 */
@Component
public class MyUtils {
    private DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Map <String, String> getDate(long timestamp) {
        Instant instant = Instant.ofEpochMilli(timestamp);
        Map <String, String> times = new LinkedHashMap <>();
        times.put("System Defult " + ZoneId.systemDefault().getId(), ZonedDateTime.ofInstant(instant, ZoneId.systemDefault()).format(timeFormatter));
        times.put("UTC", ZonedDateTime.ofInstant(instant, ZoneId.of("UTC")).format(timeFormatter));
        times.put("CTT Asia/Shanghai", ZonedDateTime.ofInstant(instant, ZoneId.of("Asia/Shanghai")).format(timeFormatter));
        times.put("CST America/Chicago", ZonedDateTime.ofInstant(instant, ZoneId.of("America/Chicago")).format(timeFormatter));
        times.put("JST Asia/Tokyo", ZonedDateTime.ofInstant(instant, ZoneId.of("Asia/Tokyo")).format(timeFormatter));
        times.put("ECT Europe/Paris", ZonedDateTime.ofInstant(instant, ZoneId.of("Europe/Paris")).format(timeFormatter));
        times.put("AET Australia/Sydney", ZonedDateTime.ofInstant(instant, ZoneId.of("Australia/Sydney")).format(timeFormatter));
        return times;
    }

    public Map getWeather(String cityId) throws IOException {
        String url = StrConstants.WEATHER_URL.getValue() + cityId + ".html";
        String datas = readURLData(url);
        Map weatherMap = new Gson().fromJson(datas, Map.class);
        Map map = (Map) weatherMap.get("weatherinfo");
        map.remove("img1");
        map.remove("img2");
        return weatherMap;
    }

    public Map getStockInfo(List <String> list) throws IOException {
        StringBuffer url = new StringBuffer().append(StrConstants.STOCK_URL.getValue());
        list.forEach(s -> {
            String head = Integer.parseInt(String.valueOf(s.charAt(0))) > 4 ? "0" : "1";
            head = StrConstants.SH_STOCK.getValue().equals(s) || StrConstants.SH_STOCK_A.getValue().equals(s)
                    ? "0" : head;
            url.append(head).append(s).append("%2C");
        });
        String datas = readURLData(url.append("money.api").toString());
        datas = datas.substring(datas.indexOf("(") + 1, datas.lastIndexOf(")"));
        Map <String, Map <String, Object>> stockMap = new Gson().fromJson(datas, Map.class);
        stockMap.forEach((k, v) -> {
            v.keySet().removeIf(key -> key.startsWith("ask") || key.startsWith("bid"));
        });

        return stockMap;
    }


    private String readURLData(String strUrl) throws IOException {
        URL url = new URL(strUrl);
        URLConnection connectionData = url.openConnection();
        connectionData.setConnectTimeout(2000);
        BufferedReader br = new BufferedReader(new InputStreamReader(
                connectionData.getInputStream(), StrConstants.UTF8.getValue()));
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = br.readLine()) != null)
            sb.append(line);
        return sb.toString();
    }

}

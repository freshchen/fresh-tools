package com.github.freshchen.javatools.util;

import com.github.freshchen.javatools.constant.StrConstants;
import com.github.freshchen.javatools.structure.VVVNode;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @program: fresh-tools
 * @Date: 2019/9/21 10:51
 * @Author: Ling Chen
 * @Description:
 */
@Component
public class MyUtils {

    private static final Comparator <VVVNode <String, Integer, Integer>> comparatorMapByValueAsc = (node1, node2) -> {
        return node1.getV2() - node2.getV2();
    };

    private static final Comparator <VVVNode <String, Integer, Integer>> comparatorMapByValueDes = (node1, node2) -> {
        return node2.getV3() - node1.getV3();
    };

    private DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private Random random = new Random();

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
        connectionData.setConnectTimeout(10000);
        BufferedReader br = new BufferedReader(new InputStreamReader(
                connectionData.getInputStream(), StrConstants.UTF8.getValue()));
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = br.readLine()) != null)
            sb.append(line);
        return sb.toString();
    }

    public String doubleColorBall() {
        Set <Integer> redBalls = new TreeSet <>(Comparator.naturalOrder());
        while (redBalls.size() < 6) {
            redBalls.add(random.nextInt(33) + 1);
        }
        StringBuffer buffer = new StringBuffer().append("Red: ");
        redBalls.forEach(num -> {
            buffer.append(num + " ");
        });
        buffer.append("Blue: " + Integer.valueOf(random.nextInt(16) + 1));
        return buffer.toString();
    }

    public String superLotto() {
        Set <Integer> redBalls = new TreeSet <>(Comparator.naturalOrder());
        while (redBalls.size() < 5) {
            redBalls.add(random.nextInt(35) + 1);
        }
        StringBuffer buffer = new StringBuffer().append("Red: ");
        redBalls.forEach(num -> {
            buffer.append(num + " ");
        });
        Set <Integer> blueBalls = new TreeSet <>(Comparator.naturalOrder());
        buffer.append("Blue: ");
        while (blueBalls.size() < 2) {
            blueBalls.add(random.nextInt(12) + 1);
        }
        blueBalls.forEach(num -> {
            buffer.append(num + " ");
        });
        return buffer.toString();
    }

    /**
     * v1 项目名 v2 成本 v3 利益
     *
     * @param list
     * @param init
     * @param times
     * @return
     */
    public String greedyPlan(List <VVVNode <String, Integer, Integer>> list, int init, int times) {
        StringBuffer buffer = new StringBuffer().append("初始资源：").append(Integer.valueOf(init)).append(" ")
                .append("执行次数：").append(Integer.valueOf(times)).append(" ")
                .append("推荐计划：").append(" ");
        PriorityQueue <VVVNode <String, Integer, Integer>> cost = new PriorityQueue <>(comparatorMapByValueAsc);
        PriorityQueue <VVVNode <String, Integer, Integer>> profit = new PriorityQueue <>(comparatorMapByValueDes);
        list.stream().forEach(node -> {
            cost.add(node);
        });
        for (int i = 0; i < times; i++) {
            while (!cost.isEmpty() && cost.peek().getV2() <= init) {
                profit.add(cost.poll());
            }
            if (profit.isEmpty()) {
                break;
            }
            VVVNode <String, Integer, Integer> curr = profit.poll();
            init += curr.getV3();
            buffer.append("任务").append(Integer.valueOf(i + 1)).append("：").append(curr.getV1()).append(" ");
        }
        buffer.append("最终资源：").append(Integer.valueOf(init));
        return buffer.toString();
    }


    public BigInteger factorial(int num) {
        ArrayList list = new ArrayList();
        list.add(BigInteger.valueOf(1));
        for (int i = list.size(); i <= num; i++) {
            BigInteger lastfact = (BigInteger) list.get(i - 1);//获得第一个元素
            BigInteger nextfact = lastfact.multiply(BigInteger.valueOf(i));//获得下一个数组
            list.add(nextfact);
        }
        return (BigInteger) list.get(num);//返回数组中的下标为num的值
    }

    public long accumulator(long num1, long num2) {
        long from = Math.min(num1, num2);
        long to = Math.max(num1, num2);
        long result = from;
        while (from < to) {
            result += ++from;
        }
        return result;
    }

}

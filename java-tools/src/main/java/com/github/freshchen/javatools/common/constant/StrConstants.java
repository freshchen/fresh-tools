package com.github.freshchen.javatools.common.constant;

import lombok.Getter;

/**
 * @program: fresh-tools
 * @Date: 2019/9/21 14:30
 * @Author: Ling Chen
 * @Description:
 */
@Getter
public enum StrConstants {
    WEATHER_URL("http://www.weather.com.cn/data/cityinfo/"),
    STOCK_URL("http://api.money.126.net/data/feed/"),
    UTF8("UTF-8"),
    SONG_JIANG("101020900"),
    SHANG_HAI("101020100"),
    TAI_XING("101191203"),
    ZHOU_SHAN("101211101"),
    BEI_JING("101010100"),
    SH_STOCK("000001"),
    SH_STOCK_A("000002"),
    SZ_STOCK("399001"),
    SZ_STOCK_NEW("399006")
    ;

    private String value;


    StrConstants(String value) {
        this.value = value;
    }
}

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
    UTF8("UTF-8"),
    SONG_JIANG("101020900"),
    SHANG_HAI("101020100"),
    TAI_XING("101191203"),
    ZHOU_SHAN("101211101"),
    BEI_JING("101010100"),
    ;

    private String value;


    StrConstants(String value) {
        this.value = value;
    }
}

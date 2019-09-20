package com.github.freshchen.javatools.service;


import com.github.freshchen.javatools.pojo.TextResponse;

/**
 * @program: fresh-tools
 * @Date: 2019/8/1 21:44
 * @Author: Ling Chen
 * @Description:
 */
public interface DigestService {
    TextResponse md5(String text);

    TextResponse sha1(String text);

    TextResponse sha256(String text);
}

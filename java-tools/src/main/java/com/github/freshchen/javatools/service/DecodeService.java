package com.github.freshchen.javatools.service;

import com.github.freshchen.javatools.pojo.TextResponse;

/**
 * @program: fresh-tools
 * @Date: 2019/7/31 20:26
 * @Author: Ling Chen
 * @Description:
 */
public interface DecodeService {

    TextResponse base64(String text);

    TextResponse base32(String text);

    TextResponse aes(String text, String key);

    TextResponse des(String text, String key);

    TextResponse rsa(String text, String key);

    TextResponse rc4(String text, String key);

}

package com.github.freshchen.javatools.service;

import com.github.freshchen.javatools.pojo.response.KeyTextResponse;
import com.github.freshchen.javatools.pojo.response.TextResponse;

/**
 * @program: fresh-tools
 * @Date: 2019/7/31 20:26
 * @Author: Ling Chen
 * @Description:
 */
public interface EncodeService {
    TextResponse base64(String text);

    TextResponse base32(String text);

    KeyTextResponse aes(String text);

    KeyTextResponse des(String text);

    KeyTextResponse rsa(String text);

    KeyTextResponse rc4(String text, String key);

}

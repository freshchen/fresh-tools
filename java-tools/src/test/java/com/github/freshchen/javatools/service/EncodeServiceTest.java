package com.github.freshchen.javatools.service;

import com.github.freshchen.javatools.pojo.response.KeyTextResponse;
import com.github.freshchen.javatools.pojo.response.TextResponse;
import com.github.freshchen.javatools.service.impl.DecodeServiceImpl;
import com.github.freshchen.javatools.service.impl.EncodeServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @program: fresh-tools
 * @Date: 2019/9/20 22:25
 * @Author: Ling Chen
 * @Description:
 */
public class EncodeServiceTest {

    private DecodeService decodeService;
    private EncodeService encodeService;
    private String sample = "jinitaimei";

    @Before
    public void setUp() throws Exception {
        decodeService = new DecodeServiceImpl();
        encodeService = new EncodeServiceImpl();
    }

    @Test
    public void base64() {
        TextResponse response = encodeService.base64(sample);
        Assert.assertEquals(decodeService.base64(response.getText()).getText(), sample);
    }

    @Test
    public void base32() {
        TextResponse response = encodeService.base32(sample);
        Assert.assertEquals(decodeService.base32(response.getText()).getText(), sample);
    }

    @Test
    public void aes() {
        KeyTextResponse response = encodeService.aes(sample);
        Assert.assertEquals(decodeService.aes(response.getText(), response.getKey()).getText(), sample);
    }

    @Test
    public void des() {
        KeyTextResponse response = encodeService.des(sample);
        Assert.assertEquals(decodeService.des(response.getText(), response.getKey()).getText(), sample);
    }

    @Test
    public void rsa() {
        KeyTextResponse response = encodeService.rsa(sample);
        Assert.assertEquals(decodeService.rsa(response.getText(), response.getKey()).getText(), sample);
    }

    @Test
    public void rc4() {
        KeyTextResponse response = encodeService.rc4(sample, sample);
        Assert.assertEquals(decodeService.rc4(response.getText(), response.getKey()).getText(), sample);
    }
}
package com.github.freshchen.javatools.service;

import com.github.freshchen.javatools.service.impl.DecodeServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @program: fresh-tools
 * @Date: 2019/9/20 22:23
 * @Author: Ling Chen
 * @Description:
 */
public class DecodeServiceTest {

    private DecodeService decodeService;
    private String sample = "Hello World";

    @Before
    public void setUp() throws Exception {
        decodeService = new DecodeServiceImpl();
    }

    @Test
    public void base64() {

    }

    @Test
    public void base32() {
    }

    @Test
    public void aes() {
    }

    @Test
    public void des() {
    }

    @Test
    public void rsa() {
    }

    @Test
    public void rc4() {
    }
}
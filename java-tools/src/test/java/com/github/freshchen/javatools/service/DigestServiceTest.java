package com.github.freshchen.javatools.service;

import com.github.freshchen.javatools.service.impl.DigestServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @program: fresh-tools
 * @Date: 2019/9/20 22:26
 * @Author: Ling Chen
 * @Description:
 */
public class DigestServiceTest {

    DigestService digestService;
    private String sample = "Hello World";

    @Before
    public void setUp() throws Exception {
        digestService = new DigestServiceImpl();
    }

    @Test
    public void md5() {
        Assert.assertEquals(digestService.md5(sample).getText(), "b10a8db164e0754105b7a99be72e3fe5");
    }

    @Test
    public void sha1() {
        Assert.assertEquals(digestService.sha1(sample).getText(), "0a4d55a8d778e5022fab701977c5d840bbc486d0");
    }

    @Test
    public void sha256() {
        Assert.assertEquals(digestService.sha256(sample).getText(), "a591a6d40bf420404a011733cfb7b190d62c65bf0bcda32b57b277d9ad9f146e");
    }
}
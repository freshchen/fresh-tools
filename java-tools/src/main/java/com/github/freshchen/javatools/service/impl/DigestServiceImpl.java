package com.github.freshchen.javatools.service.impl;

import cn.hutool.crypto.digest.DigestUtil;
import com.github.freshchen.javatools.pojo.response.TextResponse;
import com.github.freshchen.javatools.service.DigestService;
import org.springframework.stereotype.Service;

/**
 * @program: fresh-tools
 * @Date: 2019/8/1 21:44
 * @Author: Ling Chen
 * @Description:
 */
@Service
public class DigestServiceImpl implements DigestService {
    @Override
    public TextResponse md5(String text) {
        return new TextResponse(DigestUtil.md5Hex(text));
    }

    @Override
    public TextResponse sha1(String text) {
        return new TextResponse(DigestUtil.sha1Hex(text));
    }

    @Override
    public TextResponse sha256(String text) {
        return new TextResponse(DigestUtil.sha256Hex(text));
    }
}

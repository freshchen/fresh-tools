package com.github.freshchen.javatools.controller;

import com.github.freshchen.javatools.pojo.KeyTextRequest;
import com.github.freshchen.javatools.pojo.KeyTextResponse;
import com.github.freshchen.javatools.pojo.TextRequest;
import com.github.freshchen.javatools.pojo.TextResponse;
import com.github.freshchen.javatools.service.DecodeService;
import com.github.freshchen.javatools.service.DigestService;
import com.github.freshchen.javatools.service.EncodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: fresh-tools
 * @Date: 2019/9/20 21:55
 * @Author: Ling Chen
 * @Description:
 */
@RestController
@RequestMapping("/crypto/")
public class CryptoController {

    @Autowired
    private DecodeService decodeService;
    @Autowired
    private DigestService digesterAndHMacService;
    @Autowired
    private EncodeService encodeService;

    @PostMapping("/encode/base64/")
    public TextResponse encodeBase64(@RequestBody TextRequest request) {
        return encodeService.base64(request.getText());
    }

    @PostMapping("/encode/base32/")
    public TextResponse encodeBase32(@RequestBody TextRequest request) {
        return encodeService.base32(request.getText());
    }

    @PostMapping("/encode/aes/")
    public KeyTextResponse encodeAes(@RequestBody TextRequest request) {
        return encodeService.aes(request.getText());
    }

    @PostMapping("/encode/des/")
    public KeyTextResponse encodeDes(@RequestBody TextRequest request) {
        return encodeService.des(request.getText());
    }

    @PostMapping("/encode/rsa/")
    public KeyTextResponse encodeRsa(@RequestBody TextRequest request) {
        return encodeService.rsa(request.getText());
    }

    @PostMapping("/encode/rc4/")
    public KeyTextResponse encodeRc4(@RequestBody KeyTextRequest request) {
        return encodeService.rc4(request.getText(), request.getKey());
    }

    @PostMapping("/decode/base64/")
    public TextResponse decodeBase64(@RequestBody TextRequest request) {
        return decodeService.base64(request.getText());
    }

    @PostMapping("/decode/base32/")
    public TextResponse decodeBase32(@RequestBody TextRequest request) {
        return decodeService.base32(request.getText());
    }

    @PostMapping("/decode/aes/")
    public TextResponse decodeAes(@RequestBody KeyTextRequest request) {
        return decodeService.aes(request.getText(), request.getKey());
    }

    @PostMapping("/decode/des/")
    public TextResponse decodeDes(@RequestBody KeyTextRequest request) {
        return decodeService.des(request.getText(), request.getKey());
    }

    @PostMapping("/decode/rsa/")
    public TextResponse decodeRsa(@RequestBody KeyTextRequest request) {
        return decodeService.rsa(request.getText(), request.getKey());
    }

    @PostMapping("/decode/rc4/")
    public TextResponse decodeRc4(@RequestBody KeyTextRequest request) {
        return decodeService.rc4(request.getText(), request.getKey());
    }

    @PostMapping("/digester/md5/")
    public TextResponse md5(@RequestBody TextRequest request) {
        return digesterAndHMacService.md5(request.getText());
    }

    @PostMapping("/digester/sha1/")
    public TextResponse sha1(@RequestBody TextRequest request) {
        return digesterAndHMacService.sha1(request.getText());
    }

    @PostMapping("/digester/sha256/")
    public TextResponse sha256(@RequestBody TextRequest request) {
        return digesterAndHMacService.sha256(request.getText());
    }
}

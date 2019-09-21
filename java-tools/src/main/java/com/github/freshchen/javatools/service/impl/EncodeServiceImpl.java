package com.github.freshchen.javatools.service.impl;

import cn.hutool.core.codec.Base32;
import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.crypto.symmetric.RC4;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import com.github.freshchen.javatools.pojo.response.KeyTextResponse;
import com.github.freshchen.javatools.pojo.response.TextResponse;
import com.github.freshchen.javatools.service.EncodeService;
import org.springframework.stereotype.Service;

/**
 * @program: fresh-tools
 * @Date: 2019/7/31 20:26
 * @Author: Ling Chen
 * @Description:
 */
@Service
public class EncodeServiceImpl implements EncodeService {
    public TextResponse base64(String text) {
        return new TextResponse(Base64.encode(text));
    }

    public TextResponse base32(String text) {
        return new TextResponse(Base32.encode(text));
    }

    @Override
    public KeyTextResponse aes(String text) {
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, key);
        return new KeyTextResponse(Base64.encode(key), aes.encryptHex(text));
    }

    @Override
    public KeyTextResponse des(String text) {
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.DES.getValue()).getEncoded();
        SymmetricCrypto des = new SymmetricCrypto(SymmetricAlgorithm.DES, key);
        return new KeyTextResponse(Base64.encode(key), des.encryptHex(text));
    }

    @Override
    public KeyTextResponse rsa(String text) {
        RSA rsa = new RSA();
        byte[] encrypt = rsa.encrypt(text, KeyType.PublicKey);
        return new KeyTextResponse(rsa.getPrivateKeyBase64(), Base64.encode(encrypt));
    }

    @Override
    public KeyTextResponse rc4(String text, String key) {
        RC4 rc4 = new RC4(key);
        byte[] crypt = rc4.encrypt(text);
        return new KeyTextResponse(key, Base64.encode(crypt));
    }
}

package com.example.tools.application.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;

/**
 * @author darcy
 * @since 2020/10/25
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Passwords {

    private static final TextEncryptor TEXT_ENCRYPTOR = Encryptors.text("A-B-C", "123456");

    public static String encode(String text) {
        return TEXT_ENCRYPTOR.encrypt(text);
    }

    public static String decode(String text) {
        return TEXT_ENCRYPTOR.decrypt(text);
    }
}

package com.example.tools.controller.checker;

import com.example.tools.platform.exception.ApiException;
import com.example.tools.platform.exception.Errors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author darcy
 * @since 2020/10/25
 **/
@Component
public class PasswordChecker {

    @Value("${freshchen.password.salt}")
    private String realSalt;

    public void checkSalt(String salt) {
        if (!salt.equals(realSalt)) {
            throw new ApiException(Errors.BAD_PARAMS);
        }
    }
}

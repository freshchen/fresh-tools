package com.example.tools.platform.util;


import com.example.tools.platform.exception.ApiException;
import com.example.tools.platform.exception.Error;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author darcy
 * @since 2020/06/27
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiAsserts {

    public static void isTrue(boolean expression, Error error, String message) {
        if (!expression) {
            throw new ApiException(error, message);
        }
    }

    public static void isTrue(boolean expression, Error error) {
        if (!expression) {
            throw new ApiException(error);
        }
    }

    public static void isFalse(boolean expression, Error error, String message) {
        if (expression) {
            throw new ApiException(error, message);
        }
    }

    public static void isFalse(boolean expression, Error error) {
        if (expression) {
            throw new ApiException(error);
        }
    }

}

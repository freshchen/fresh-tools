package com.github.freshchen.javatools.pojo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: fresh-ad-system
 * @Date: 2019/6/25 22:48
 * @Author: Ling Chen
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> implements Serializable {

    private static final long serialVersionUID = -3859183652214035382L;
    private int code;
    private String message;
    private T data;

    public CommonResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }
}

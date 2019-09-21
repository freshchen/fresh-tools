package com.github.freshchen.javatools.pojo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @program: fresh-tools
 * @Date: 2019/7/31 20:20
 * @Author: Ling Chen
 * @Description:
 */
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KeyTextResponse implements Serializable {
    private static final long serialVersionUID = -4289104126476344035L;
    private String key;
    private String text;
}

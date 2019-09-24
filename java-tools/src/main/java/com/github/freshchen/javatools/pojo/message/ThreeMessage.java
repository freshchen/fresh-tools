package com.github.freshchen.javatools.pojo.message;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @program: fresh-tools
 * @Date: 2019/9/21 20:01
 * @Author: Ling Chen
 * @Description:
 */
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThreeMessage<E, F, G> implements Serializable {

    private static final long serialVersionUID = 4999224804562411289L;
    private E el1;
    private F el2;
    private G el3;
}

package com.github.freshchen.javatools.pojo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

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
public class ThreeRequest<E, F, G> implements Serializable {

    private static final long serialVersionUID = 4020632860503887561L;
    private E el1;
    private F el2;
    private G el3;
}

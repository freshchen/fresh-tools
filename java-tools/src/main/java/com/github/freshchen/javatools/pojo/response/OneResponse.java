package com.github.freshchen.javatools.pojo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @program: fresh-tools
 * @Date: 2019/9/22 15:06
 * @Author: Ling Chen
 * @Description:
 */
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OneResponse<E> implements Serializable {
    private static final long serialVersionUID = 3319201069661931070L;

    private E element;
}

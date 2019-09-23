package com.github.freshchen.javatools.structure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @program: fresh-algorithms
 * @Date: 2019/9/22 18:22
 * @Author: Ling Chen
 * @Description:
 */
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VVVNode<E, F, G>  {
    private E v1;
    private F v2;
    private G v3;

}

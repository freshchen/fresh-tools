package com.github.freshchen.javatools.pojo.request;

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
public class TwoRequest<E, F> implements Serializable {

    private static final long serialVersionUID = -1917222543709810627L;
    private E el;
    private F e2;
}

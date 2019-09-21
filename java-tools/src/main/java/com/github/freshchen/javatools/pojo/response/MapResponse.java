package com.github.freshchen.javatools.pojo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Map;

/**
 * @program: fresh-tools
 * @Date: 2019/9/21 10:41
 * @Author: Ling Chen
 * @Description:
 */
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MapResponse<E, F> implements Serializable {
    private Map <E, F> map;
}

package freshchen.jcrypto.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @program: fresh-tools
 * @Date: 2019/8/1 0:48
 * @Author: Ling Chen
 * @Description:
 */
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TextResponse implements Serializable {
    private static final long serialVersionUID = 6394318806140951838L;
    private String text;
}

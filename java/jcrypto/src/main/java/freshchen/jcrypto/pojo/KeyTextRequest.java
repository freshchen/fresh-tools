package freshchen.jcrypto.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @program: fresh-tools
 * @Date: 2019/8/1 0:40
 * @Author: Ling Chen
 * @Description:
 */
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KeyTextRequest implements Serializable {

    private static final long serialVersionUID = 2174704127874782396L;
    private String key;
    private String text;
}

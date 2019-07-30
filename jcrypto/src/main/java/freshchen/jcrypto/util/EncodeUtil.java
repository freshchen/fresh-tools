package freshchen.jcrypto.util;

import cn.hutool.core.codec.Base64;
import org.springframework.stereotype.Component;

/**
 * @program: fresh-tools
 * @Date: 2019/7/30 23:04
 * @Author: Ling Chen
 * @Description:
 */
@Component
public class EncodeUtil {

    public String base64(String text) {
        return Base64.encode(text);
    }
}

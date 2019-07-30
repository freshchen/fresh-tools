package freshchen.jcrypto.util;

import cn.hutool.core.codec.Base64;
import org.springframework.stereotype.Component;

/**
 * @program: fresh-tools
 * @Date: 2019/7/30 23:13
 * @Author: Ling Chen
 * @Description:
 */
@Component
public class DecodeUtil {

    public String base64(String text) {
        return Base64.decodeStr(text);
    }
}

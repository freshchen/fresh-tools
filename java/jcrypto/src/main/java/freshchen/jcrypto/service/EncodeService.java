package freshchen.jcrypto.service;

import freshchen.jcrypto.pojo.KeyTextResponse;
import freshchen.jcrypto.pojo.TextResponse;

/**
 * @program: fresh-tools
 * @Date: 2019/7/31 20:26
 * @Author: Ling Chen
 * @Description:
 */
public interface EncodeService {
    TextResponse base64(String text);

    TextResponse base32(String text);

    KeyTextResponse aes(String text);

    KeyTextResponse des(String text);

    KeyTextResponse rsa(String text);
}

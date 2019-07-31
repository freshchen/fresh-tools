package freshchen.jcrypto.service;

import freshchen.jcrypto.pojo.KeyTextResponse;
import freshchen.jcrypto.pojo.TextResponse;

/**
 * @program: fresh-tools
 * @Date: 2019/7/31 20:26
 * @Author: Ling Chen
 * @Description:
 */
public interface DecodeService {

    KeyTextResponse base64(String text);

    KeyTextResponse base32(String text);

    KeyTextResponse aes(String text, String key);

    KeyTextResponse des(String text, String key);

    TextResponse rsa(String text, String key);
}

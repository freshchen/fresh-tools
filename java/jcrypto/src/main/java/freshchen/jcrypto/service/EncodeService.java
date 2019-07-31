package freshchen.jcrypto.service;

import freshchen.jcrypto.pojo.CryptoResponse;

/**
 * @program: fresh-tools
 * @Date: 2019/7/31 20:26
 * @Author: Ling Chen
 * @Description:
 */
public interface EncodeService {
    CryptoResponse base64(String text);

    CryptoResponse base32(String text);

    CryptoResponse aes(String text);

    CryptoResponse des(String text);

    CryptoResponse rsa(String text);
}

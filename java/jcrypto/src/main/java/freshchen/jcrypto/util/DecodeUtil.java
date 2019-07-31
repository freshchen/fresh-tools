package freshchen.jcrypto.util;

import cn.hutool.core.codec.Base32;
import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

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

    public String base32(String text) {
        return Base32.decodeStr(text);
    }

    public String aes(String text, String key){
        SecretKey keys = SecureUtil.generateKey(key);
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, keys);
        return aes.decryptStr(text, CharsetUtil.CHARSET_UTF_8);
    }
}

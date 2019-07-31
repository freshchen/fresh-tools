package freshchen.jcrypto.util;

import cn.hutool.core.codec.Base32;
import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

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

    public String base32(String text) {
        return Base32.encode(text);
    }

    public String aes(String text){
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, key);
        return aes.encryptHex(text);
    }

    public static void main(String[] args) {
        EncodeUtil util = new EncodeUtil();
        System.out.println(util.aes("1231"));
    }

}

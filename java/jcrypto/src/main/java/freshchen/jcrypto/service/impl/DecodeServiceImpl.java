package freshchen.jcrypto.service.impl;

import cn.hutool.core.codec.Base32;
import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.crypto.symmetric.RC4;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import freshchen.jcrypto.pojo.TextResponse;
import freshchen.jcrypto.service.DecodeService;
import org.springframework.stereotype.Service;

/**
 * @program: fresh-tools
 * @Date: 2019/7/31 20:26
 * @Author: Ling Chen
 * @Description:
 */
@Service
public class DecodeServiceImpl implements DecodeService {

    public TextResponse base64(String text) {
        return new TextResponse(Base64.decodeStr(text));
    }

    public TextResponse base32(String text) {
        return new TextResponse(Base32.decodeStr(text));
    }

    @Override
    public TextResponse aes(String text, String key) {
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, Base64.decode(key));
        return new TextResponse(aes.decryptStr(text, CharsetUtil.CHARSET_UTF_8));
    }

    @Override
    public TextResponse des(String text, String key) {
        SymmetricCrypto des = new SymmetricCrypto(SymmetricAlgorithm.DES, Base64.decode(key));
        return new TextResponse(des.decryptStr(text, CharsetUtil.CHARSET_UTF_8));
    }

    @Override
    public TextResponse rsa(String text, String key) {
        RSA rsa = new RSA(key,null);
        return new TextResponse(rsa.decryptStr(StrUtil.str(text, CharsetUtil.CHARSET_UTF_8), KeyType.PrivateKey));
    }

    @Override
    public TextResponse rc4(String text, String key) {
        RC4 rc4 = new RC4(key);
        return new TextResponse(rc4.decrypt(Base64.decode(text)));
    }


}

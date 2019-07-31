package freshchen.jcrypto.service.impl;

import cn.hutool.core.codec.Base32;
import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import freshchen.jcrypto.pojo.CryptoResponse;
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

    public CryptoResponse base64(String text) {
        return new CryptoResponse(Base64.decodeStr(text));
    }

    public CryptoResponse base32(String text) {
        return new CryptoResponse(Base32.decodeStr(text));
    }

    @Override
    public CryptoResponse aes(String text, String key) {
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, Base64.decode(key));
        return new CryptoResponse(aes.decryptStr(text, CharsetUtil.CHARSET_UTF_8));
    }

    @Override
    public CryptoResponse des(String text, String key) {
        SymmetricCrypto des = new SymmetricCrypto(SymmetricAlgorithm.DES, Base64.decode(key));
        return new CryptoResponse(des.decryptStr(text, CharsetUtil.CHARSET_UTF_8));
    }

    @Override
    public CryptoResponse rsa(String text, String key) {
        RSA rsa = new RSA(null,key);
        return new CryptoResponse(rsa.decryptStr(StrUtil.str(text, CharsetUtil.CHARSET_UTF_8), KeyType.PublicKey));
    }

}

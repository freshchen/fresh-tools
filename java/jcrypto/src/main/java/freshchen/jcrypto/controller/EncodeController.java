package freshchen.jcrypto.controller;

import freshchen.jcrypto.pojo.CryptoResponse;
import freshchen.jcrypto.service.EncodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: fresh-tools
 * @Date: 2019/7/30 23:06
 * @Author: Ling Chen
 * @Description:
 */
@RestController
@RequestMapping("/encode")
public class EncodeController {

    @Autowired
    private EncodeService encodeService;

    @GetMapping("/base64/{text}")
    public CryptoResponse base64(@PathVariable String text) {
        return encodeService.base64(text);
    }

    @GetMapping("/base32/{text}")
    public CryptoResponse base32(@PathVariable String text) {
        return encodeService.base32(text);
    }

    @GetMapping("/aes/{text}")
    public CryptoResponse aes(@PathVariable String text) {
        return encodeService.aes(text);
    }

    @GetMapping("/des/{text}")
    public CryptoResponse des(@PathVariable String text) {
        return encodeService.des(text);
    }

    @GetMapping("/rsa/{text}")
    public CryptoResponse rsa(@PathVariable String text) {
        return encodeService.rsa(text);
    }
}

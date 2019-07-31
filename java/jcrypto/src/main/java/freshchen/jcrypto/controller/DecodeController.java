package freshchen.jcrypto.controller;

import freshchen.jcrypto.pojo.CryptoResponse;
import freshchen.jcrypto.service.DecodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: fresh-tools
 * @Date: 2019/7/30 23:12
 * @Author: Ling Chen
 * @Description:
 */
@RestController
@RequestMapping("/decode")
public class DecodeController {

    @Autowired
    private DecodeService decodeService;

    @GetMapping("/base64/{text}")
    public CryptoResponse base64(@PathVariable String text) {
        return decodeService.base64(text);
    }

    @GetMapping("/base32/{text}")
    public CryptoResponse base32(@PathVariable String text) {
        return decodeService.base32(text);
    }

    @GetMapping("/aes/{text}/{key}")
    public CryptoResponse aes(@PathVariable String text, @PathVariable String key) {
        return decodeService.aes(text, key);
    }

    @GetMapping("/des/{text}/{key}")
    public CryptoResponse des(@PathVariable String text, @PathVariable String key) {
        return decodeService.des(text, key);
    }

    @GetMapping("/rsa/{text}/{key}")
    public CryptoResponse rsa(@PathVariable String text, @PathVariable String key) {
        return decodeService.rsa(text, key);
    }
}

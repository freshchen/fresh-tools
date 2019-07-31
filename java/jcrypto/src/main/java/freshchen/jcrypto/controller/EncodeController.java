package freshchen.jcrypto.controller;

import freshchen.jcrypto.pojo.KeyTextResponse;
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

    @PostMapping("/base64/{text}")
    public KeyTextResponse base64(@PathVariable String text) {
        return encodeService.base64(text);
    }

    @PostMapping("/base32/{text}")
    public KeyTextResponse base32(@PathVariable String text) {
        return encodeService.base32(text);
    }

    @PostMapping("/aes/{text}")
    public KeyTextResponse aes(@PathVariable String text) {
        return encodeService.aes(text);
    }

    @PostMapping("/des/{text}")
    public KeyTextResponse des(@PathVariable String text) {
        return encodeService.des(text);
    }

    @PostMapping("/rsa/{text}")
    public KeyTextResponse rsa(@PathVariable String text) {
        return encodeService.rsa(text);
    }
}

package freshchen.jcrypto.controller;

import freshchen.jcrypto.pojo.KeyTextResponse;
import freshchen.jcrypto.pojo.KeyTextRequest;
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

    @PostMapping("/base64/{text}")
    public KeyTextResponse base64(@PathVariable String text) {
        return decodeService.base64(text);
    }

    @PostMapping("/base32/{text}")
    public KeyTextResponse base32(@PathVariable String text) {
        return decodeService.base32(text);
    }

    @PostMapping("/aes/{text}/{key}")
    public KeyTextResponse aes(@RequestBody KeyTextRequest request) {
        return decodeService.aes(request.getText(), request.getKey());
    }

    @PostMapping("/des/")
    public KeyTextResponse des(@RequestBody KeyTextRequest request) {
        return decodeService.des(request.getText(), request.getKey());
    }

    @PostMapping("/rsa/")
    public KeyTextResponse rsa(@RequestBody KeyTextRequest request) {
        return decodeService.rsa(request.getText(), request.getKey());
    }
}

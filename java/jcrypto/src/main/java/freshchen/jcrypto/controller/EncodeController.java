package freshchen.jcrypto.controller;

import freshchen.jcrypto.pojo.KeyTextRequest;
import freshchen.jcrypto.pojo.KeyTextResponse;
import freshchen.jcrypto.pojo.TextRequest;
import freshchen.jcrypto.pojo.TextResponse;
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

    @PostMapping("/base64/")
    public TextResponse base64(@RequestBody TextRequest request) {
        return encodeService.base64(request.getText());
    }

    @PostMapping("/base32/")
    public TextResponse base32(@RequestBody TextRequest request) {
        return encodeService.base32(request.getText());
    }

    @PostMapping("/aes/")
    public KeyTextResponse aes(@RequestBody TextRequest request) {
        return encodeService.aes(request.getText());
    }

    @PostMapping("/des/")
    public KeyTextResponse des(@RequestBody TextRequest request) {
        return encodeService.des(request.getText());
    }

    @PostMapping("/rsa/")
    public KeyTextResponse rsa(@RequestBody TextRequest request) {
        return encodeService.rsa(request.getText());
    }
}

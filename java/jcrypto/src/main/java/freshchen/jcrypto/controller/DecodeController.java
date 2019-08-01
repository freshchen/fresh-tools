package freshchen.jcrypto.controller;

import freshchen.jcrypto.pojo.KeyTextRequest;
import freshchen.jcrypto.pojo.TextRequest;
import freshchen.jcrypto.pojo.TextResponse;
import freshchen.jcrypto.service.DecodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/base64/")
    public TextResponse base64(@RequestBody TextRequest request) {
        return decodeService.base64(request.getText());
    }

    @PostMapping("/base32/")
    public TextResponse base32(@RequestBody TextRequest request) {
        return decodeService.base32(request.getText());
    }

    @PostMapping("/aes/")
    public TextResponse aes(@RequestBody KeyTextRequest request) {
        return decodeService.aes(request.getText(), request.getKey());
    }

    @PostMapping("/des/")
    public TextResponse des(@RequestBody KeyTextRequest request) {
        return decodeService.des(request.getText(), request.getKey());
    }

    @PostMapping("/rsa/")
    public TextResponse rsa(@RequestBody KeyTextRequest request) {
        return decodeService.rsa(request.getText(), request.getKey());
    }

    @PostMapping("/rc4/")
    public TextResponse rc4(@RequestBody KeyTextRequest request) {
        return decodeService.rc4(request.getText(), request.getKey());
    }

}

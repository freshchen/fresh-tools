package freshchen.jcrypto.controller;

import freshchen.jcrypto.pojo.TextRequest;
import freshchen.jcrypto.pojo.TextResponse;
import freshchen.jcrypto.service.DigestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: fresh-tools
 * @Date: 2019/8/1 21:41
 * @Author: Ling Chen
 * @Description:
 */
@RestController
@RequestMapping("/digester")
public class DigestController {

    @Autowired
    private DigestService digesterAndHMacService;

    @PostMapping("/md5")
    public TextResponse md5(@RequestBody TextRequest request){
        return digesterAndHMacService.md5(request.getText());
    }

    @PostMapping("/sha1")
    public TextResponse sha1(@RequestBody TextRequest request){
        return digesterAndHMacService.sha1(request.getText());
    }

    @PostMapping("/sha256")
    public TextResponse sha256(@RequestBody TextRequest request){
        return digesterAndHMacService.sha256(request.getText());
    }

}

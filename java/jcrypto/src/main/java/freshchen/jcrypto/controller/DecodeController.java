package freshchen.jcrypto.controller;

import freshchen.jcrypto.util.DecodeUtil;
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
    private DecodeUtil decodeUtil;

    @PostMapping("/base64/{text}")
    public String base64(@PathVariable String text){
        return decodeUtil.base64(text);
    }

    @PostMapping("/base32/{text}")
    public String base32(@PathVariable String text){
        return decodeUtil.base32(text);
    }
}

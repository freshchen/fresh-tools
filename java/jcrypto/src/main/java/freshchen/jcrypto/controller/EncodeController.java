package freshchen.jcrypto.controller;

import freshchen.jcrypto.util.EncodeUtil;
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
    private EncodeUtil encodeUtil;

    @PostMapping("/base64/{text}")
    public String base64(@PathVariable String text) {
        return encodeUtil.base64(text);
    }

    @PostMapping("/base32/{text}")
    public String base32(@PathVariable String text) {
        return encodeUtil.base32(text);
    }

//    @PostMapping("/aes/{text}")
//    public String aes(@PathVariable String text) {
//        return encodeUtil.aes(text);
//    }
}

package freshchen.jcrypto.controller;

import freshchen.jcrypto.util.DecodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
    private DecodeUtil decodeUtil;

    @RequestMapping("/base64/{text}")
    public String base64(@PathVariable String text){
        return decodeUtil.base64(text);
    }
}

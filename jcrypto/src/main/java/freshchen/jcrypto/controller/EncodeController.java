package freshchen.jcrypto.controller;

import freshchen.jcrypto.util.EncodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/base64/{text}")
    public String base64(@PathVariable String text){
        return encodeUtil.base64(text);
    }
}

package freshchen.jcrypto.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @program: fresh-tools
 * @Date: 2019/7/31 20:20
 * @Author: Ling Chen
 * @Description:
 */
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CryptoResponse {
    private String key;
    private String text;

    public CryptoResponse(String text) {
        this.text = text;
    }
}

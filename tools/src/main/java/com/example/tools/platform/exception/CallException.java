package com.example.tools.platform.exception;


import com.example.tools.platform.model.JsonResult;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotNull;

/**
 * @author darcy
 * @since 2020/06/10
 **/
@Getter
public class CallException extends RuntimeException {
    /**
     * 远程调用结果
     */
    private final JsonResult<?> jsonResult;

    public CallException(@NotNull JsonResult<?> jsonResult) {
        super(StringUtils.join(jsonResult.getErrCode().orElse(0), jsonResult.getErrMessage().orElse("服务异常")));
        this.jsonResult = jsonResult;
    }
}

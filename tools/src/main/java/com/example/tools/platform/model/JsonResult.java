package com.example.tools.platform.model;


import com.example.tools.platform.exception.CallException;
import com.example.tools.platform.exception.Error;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotNull;
import java.util.Optional;

import static com.example.tools.platform.exception.Errors.SERVER_ERROR;


/**
 * @author darcy
 * @since 2020/06/10
 **/
@Data
@ApiModel
public class JsonResult<T> {

    /**
     * 是否成功
     */
    @NonNull
    @ApiModelProperty("是否成功")
    private boolean success;

    /**
     * 响应结果
     */
    @ApiModelProperty("响应结果")
    private Optional<T> data = Optional.empty();

    /**
     * 错误码
     */
    @ApiModelProperty("错误码")
    private Optional<Integer> errCode = Optional.empty();

    /**
     * 错误消息
     */
    @ApiModelProperty("错误消息")
    private Optional<String> errMessage = Optional.empty();

    /**
     * 检查传入的调用结果，如果成功并且响应结果不为空，则返回响应结果，否则抛出{@code CallException}。
     *
     * @param jsonResult
     * @param <T>
     * @return
     */
    public static <T> T checkAndExtract(@NotNull JsonResult<T> jsonResult) {
        if (jsonResult.isSuccess() && jsonResult.getData().isPresent()) {
            return jsonResult.getData().get();
        }
        throw new CallException(jsonResult);
    }

    /**
     * 检查传入的调用结果，如果成功，则返回响应结果，否则抛出{@code CallException}。
     *
     * @param jsonResult
     * @param <T>
     * @return
     */
    public static <T> Optional<T> checkAndExtractOptional(@NotNull JsonResult<T> jsonResult) {
        if (jsonResult.isSuccess()) {
            return jsonResult.getData();
        }
        throw new CallException(jsonResult);
    }

    public static <T> boolean check(@NotNull JsonResult<T> jsonResult) {
        return jsonResult.isSuccess();
    }

    /**
     * 生成服务调用成功响应
     *
     * @param <T>
     * @return
     */
    public static <T> JsonResult<T> ok() {
        return new JsonResult<>(true);
    }

    /**
     * 生成服务调用成功响应
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> JsonResult<T> ok(@NotNull T data) {
        JsonResult<T> jsonResult = new JsonResult<>(true);
        jsonResult.setData(Optional.of(data));
        return jsonResult;
    }


    /**
     * 生成服务调用错误响应
     *
     * @param <T>
     * @return
     */
    public static <T> JsonResult<T> error() {
        return error(SERVER_ERROR);
    }

    /**
     * 生成服务调用错误响应
     *
     * @param errorMessage
     * @param <T>
     * @return
     */
    public static <T> JsonResult<T> error(String errorMessage) {
        return error(SERVER_ERROR.getCode(), errorMessage);
    }

    /**
     * 生成服务调用错误响应
     *
     * @param error
     * @param <T>
     * @return
     */
    public static <T> JsonResult<T> error(Error error) {
        return error(error.getCode(), error.getMessage());
    }

    /**
     * 生成服务调用错误响应
     *
     * @param errorCode
     * @param errorMessage
     * @param <T>
     * @return
     */
    public static <T> JsonResult<T> error(Integer errorCode, String errorMessage) {
        JsonResult<T> jsonResult = new JsonResult<>(false);
        jsonResult.setErrCode(Optional.ofNullable(errorCode));
        jsonResult.setErrMessage(Optional.ofNullable(errorMessage));
        return jsonResult;
    }
}

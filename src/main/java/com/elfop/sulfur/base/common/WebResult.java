package com.elfop.sulfur.base.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

import static com.elfop.sulfur.base.common.Dic.RESULT_CODE_FAIL;
import static com.elfop.sulfur.base.common.Dic.RESULT_CODE_SUCCESS;


/**
 * @Description: 统一的数据返回对象
 * @author: liu zhenming
 * @version: V1.0
 * @date: 2019/7/9  10:12
 */
@Data
@Slf4j
@Builder
@ApiModel(value = "统一数据返回对象", description = "所有数据经此包装")
public class WebResult<T> implements Serializable {

    public static final String REQUEST_STATUS_ERROR = "error";
    public static final String REQUEST_STATUS_SUCCESS = "success";
    private static final long serialVersionUID = 1L;
    /**
     * 状态码
     */
    @ApiModelProperty(required = true, value = "返回状态码", dataType = "int", example = "200", position = 0)
    private int code;
    /**
     * 返回数据
     */
    @ApiModelProperty(required = true, value = "返回数据", dataType = "string", example = "{'version': '3.0.5'}", position = 1)
    private T data;
    /**
     * msg信息
     */
    @ApiModelProperty(required = true, value = "返回message 信息", dataType = "string", example = "success", position = 2)
    private String message;
    /**
     * ok or error
     */
    @ApiModelProperty(required = true, value = "返回接口调用成功or失败信息", dataType = "string", example = "ok", position = 3)
    private String status;

    /**
     * 成功操作 操作码默认为200   无参
     *
     * @return
     */
    public static WebResult okResult() {
        return okResult("");
    }

    /**
     * 成功操作 设置数据
     **/
    public static <T> WebResult<T> okResult(T data) {
        return okResult(RESULT_CODE_SUCCESS, data);
    }

    /**
     * 成功操作 设置返回码及数据
     **/
    public static <T> WebResult<T> okResult(int code, T data) {
        return okResult(code, REQUEST_STATUS_SUCCESS, data);
    }


    /**
     * 成功操作 设置返回码及数据及message信息
     **/
    public static <T> WebResult<T> okResult(int code, String msg, T data) {
        return WebResult.<T>builder()
                .data(data)
                .code(code)
                .message(msg)
                .status(REQUEST_STATUS_SUCCESS)
                .build();
    }

    /**
     * 失败返回 无参
     *
     * @return
     */
    public static WebResult failResult() {
        return failResult("");
    }

    /**
     * 失败返回 设置失败码
     **/
    public static WebResult failResult(int code) {
        return failResult(code, REQUEST_STATUS_ERROR);
    }

    /**
     * 失败返回 设置msg
     **/
    public static WebResult failResult(String msg) {
        return failResult(RESULT_CODE_FAIL, msg);
    }

    /**
     * 失败返回 设置返回码及msg
     **/
    public static WebResult failResult(int code, String msg) {
        return failResult(code, msg, "");
    }


    /**
     * 失败返回 设置返回码及数据及message信息
     **/
    public static <T> WebResult<T> failResult(int code, String msg, T data) {
        return WebResult.<T>builder()
                .data(data)
                .code(code)
                .message(msg)
                .status(REQUEST_STATUS_ERROR)
                .build();
    }

}

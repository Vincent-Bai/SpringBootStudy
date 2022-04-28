package com.bai.SpringBootStudy.SpringBootStudy.common.enums;

public enum ResultCode {
    /* 成功状态码 */
    SUCCESS(200,"成功"),

    //400系列
    BAD_REQUEST(400,"请求的数据格式不符!"),
    UNAUTHORIZED(401,"登录凭证过期!"),
    FORBIDDEN(403,"抱歉，你无权限访问!"),
    NOT_FOUND(404, "请求的资源找不到!"),

    //500系列
    INTERNAL_SERVER_ERROR(500, "服务器内部错误!"),
    SERVICE_UNAVAILABLE(503,"服务器正忙，请稍后再试!"),
    PARAMETER_EXCEPTION(501,"请求参数校验异常"),

    /* 业务状态码 */
    USER_NOT_EXIST_ERROR(10001,"用户不存在"),

    //未知异常
    UNKNOWN(10000,"未知异常!"),
    ;

    private Integer code;
    private String message;

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

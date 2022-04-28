package com.bai.SpringBootStudy.SpringBootStudy.common.exception;

import com.bai.SpringBootStudy.SpringBootStudy.common.enums.ResultCode;
import lombok.Data;
import lombok.Getter;

import static com.bai.SpringBootStudy.SpringBootStudy.common.enums.ResultCode.INTERNAL_SERVER_ERROR;

/**
 * 自定义也无异常基类
 *
 * @author vincent
 */
@Data
public class BaseException extends RuntimeException {

    private static final Integer BASE_EXCEPTION_CODE = INTERNAL_SERVER_ERROR.getCode();
    private static final String BASE_EXCEPTION_MESSAGE = INTERNAL_SERVER_ERROR.getMessage();

    private Integer code;
    private String message;

    public BaseException() {
        super(INTERNAL_SERVER_ERROR.getMessage());
        this.code = BASE_EXCEPTION_CODE;
        this.message = BASE_EXCEPTION_MESSAGE;
    }

    public BaseException(String message) {
        super(message);
        this.code = BASE_EXCEPTION_CODE;
        this.message = message;
    }

    public BaseException(ResultCode resultCode) {
        super(resultCode.getMessage());
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public BaseException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BaseException(Throwable cause) {
        super(cause);
        this.code = BASE_EXCEPTION_CODE;
        this.message = BASE_EXCEPTION_MESSAGE;
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
        this.code = BASE_EXCEPTION_CODE;
        this.message = message;
    }

    public BaseException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }
}

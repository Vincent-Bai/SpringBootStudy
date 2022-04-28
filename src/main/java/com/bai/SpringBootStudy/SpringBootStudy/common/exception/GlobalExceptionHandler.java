package com.bai.SpringBootStudy.SpringBootStudy.common.exception;

import com.bai.SpringBootStudy.SpringBootStudy.common.Result;
import com.bai.SpringBootStudy.SpringBootStudy.common.enums.ResultCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 全局异常处理类
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
   // private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /*处理自定义业务异常*/
    @ExceptionHandler(value = BizException.class)
    public Result handlerBizException(BizException e) {
        //log.error("发生业务异常！原因是：{}", e.getMessage());
        return Result.faild(e.getCode(), e.getMessage());
    }

    /**
     * 空指针异常
     */
    @ExceptionHandler(value = NullPointerException.class)
    public Result handlerNullException(NullPointerException e) {
        //log.error("发生空指针异常:{}", e.getMessage());
        return Result.faild(ResultCode.BAD_REQUEST);
    }

    /**
     * 404处理
     */
    @ExceptionHandler(value = NoHandlerFoundException.class)
    public Result handlerNoHandlerFoundException(NoHandlerFoundException e) {
        return Result.faild(ResultCode.NOT_FOUND);
    }

    /**
     * 未知异常
     */
    @ExceptionHandler(value = Exception.class)
    public Result handlerException(Exception e) {
        //log.error("发生未知异常:{}", e.getMessage());
        return Result.faild(e.getMessage());
    }

}

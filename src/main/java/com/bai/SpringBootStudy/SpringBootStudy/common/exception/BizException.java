package com.bai.SpringBootStudy.SpringBootStudy.common.exception;

import com.bai.SpringBootStudy.SpringBootStudy.common.enums.ResultCode;

/**
 * 自定义业务异常类
 * 实际开发中应该按照不同的业务模块定义不同的业务异常类。有利有弊吧。
 * 优点：子服务/子模块都有自己对应的异常处理方式，方便每个业务的扩展。
 * 缺点：每个模块/服务都要做一遍自定义异常的工作，代码冗余。
 * 扩展：如果将异常类做为一个独立的子服务jar包，其它子服务引用这个jar，如何处理不同子服务之间返回的code？如何准确定位到异常的服务及其路径？
 */
public class BizException extends BaseException{
    public BizException() {
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(ResultCode resultCode) {
        super(resultCode);
    }

    public BizException(Integer code, String message) {
        super(code, message);
    }

    public BizException(Throwable cause) {
        super(cause);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(Integer code, String message, Throwable cause) {
        super(code, message, cause);
    }
}

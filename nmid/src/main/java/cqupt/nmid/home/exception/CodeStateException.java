package cqupt.nmid.home.exception;

import cqupt.nmid.home.constant.StatusCodeConstant;
/**
 * 异常基类，带有返回异常状态码的方法
 * @author MagicWolf
 *
 */
public abstract class CodeStateException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    
    public CodeStateException() {}
    public CodeStateException(String msg) { super(msg); }
    /**
     * 异常状态码
     * @return
     */
    abstract StatusCodeConstant getExceptionState();
}

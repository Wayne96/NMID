package cqupt.nmid.home.exception;

import cqupt.nmid.home.constant.StatusCodeConstant;

/**
 * 请求参数异常
 * @author MagicWolf
 *
 */
public class RequestParamException extends CodeStateException{
    private static final long serialVersionUID = 1L;
    @Override
    StatusCodeConstant getExceptionState() {
        return StatusCodeConstant.INVALID_REQUEST;
    }
}

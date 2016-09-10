package cqupt.nmid.home.exception;

import cqupt.nmid.home.constant.StatusCodeConstant;

/**
 * 未登录异常
 * 
 * @author MagicWolf
 * 
 */
public class UnLoginExecption extends CodeStateException {
    private static final long serialVersionUID = 1L;

    @Override
    StatusCodeConstant getExceptionState() {
        return StatusCodeConstant.USER_UNLOGIN;
    }
}

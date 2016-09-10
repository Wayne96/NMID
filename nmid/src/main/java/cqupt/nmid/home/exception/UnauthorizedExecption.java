package cqupt.nmid.home.exception;

import cqupt.nmid.home.constant.StatusCodeConstant;

public class UnauthorizedExecption extends CodeStateException{
    private static final long serialVersionUID = 1L;

    @Override
    StatusCodeConstant getExceptionState() {
        return StatusCodeConstant.UNAUTHORIZED;
    }
    
}

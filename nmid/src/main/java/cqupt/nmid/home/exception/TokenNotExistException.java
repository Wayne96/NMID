package cqupt.nmid.home.exception;

import cqupt.nmid.home.constant.StatusCodeConstant;

public class TokenNotExistException extends CodeStateException{
    private static final long serialVersionUID = 1L;
    public TokenNotExistException() { }
    public TokenNotExistException(String msg) {
        super(msg);
    }
    @Override
    StatusCodeConstant getExceptionState() {
        return StatusCodeConstant.TOKEN_NOT_EXIST;
    }
    
}

/**
 * 
 */
package cqupt.nmid.home.exception;

import cqupt.nmid.home.constant.StatusCodeConstant;

/**
 * @author MaRong
 * @date 2016年1月23日 下午2:05:58
 * @description post字符串解析异常
 */
public class JsonSyntexException extends CodeStateException{

    private static final long serialVersionUID = 1L;

    public JsonSyntexException(String msg) {
        super(msg);
    }
    @Override
    StatusCodeConstant getExceptionState() {
        return StatusCodeConstant.JSON_PARSE_ERROR;
    }
}

/**
 * 
 */
package cqupt.nmid.home.model.json;

import cqupt.nmid.home.constant.StatusCodeConstant;

/**
 * @author MaRong
 * @date 2016年2月20日 下午6:18:21
 * @description 
 */
public class ResponseJson {
	private Integer code;
	private String message;
	private Object body="";
	public ResponseJson() {}
	public ResponseJson(StatusCodeConstant constant) {
    	    this.code = constant.getCode();
    	    this.message = constant.getMessage();
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}

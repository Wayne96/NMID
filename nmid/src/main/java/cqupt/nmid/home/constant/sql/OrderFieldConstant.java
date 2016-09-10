/**
 * 
 */
package cqupt.nmid.home.constant.sql;

/**
 * @author MaRong
 * @date 2016年5月13日 上午10:30:56
 * @description 
 */
public enum OrderFieldConstant {
    DESC("desc"),ASC("asc");
    
    private String value;
    public String getValue() {
	return value;
    }
    
    OrderFieldConstant(String value) {
	this.value = value;
    }
    
    public static  OrderFieldConstant nameOf(String value) {
	if(value.equalsIgnoreCase("desc")) {
	    return DESC;
	}else if(value.equalsIgnoreCase("asc")) {
	    return ASC;
	}else {
	    return null;
	}
    }
}

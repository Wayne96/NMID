/**
 * 
 */
package cqupt.nmid.home.constant;

/**
 * @author MaRong
 * @date 2016年4月29日 下午7:29:43
 * @description 新闻状态枚举类
 */
public enum StatusConstant {
    CREATE(0),CHECKED(1),FAILED(-1);
    private Integer status;
    
    StatusConstant(Integer status) {
	this.status = status;
    }
    
    public Integer getValue() {
	return status;
    }
    
    public static StatusConstant valueOf(Integer value) {
	if(value == 0) {
	    return CREATE;
	}else if(value == 1){
	    return CHECKED;
	}else if(value == -1) {
	    return FAILED;
	}else {
	    return null;
	}
    }
}

/**
 * 
 */
package cqupt.nmid.home.constant.sql;

/**
 * @author MaRong
 * @date 2016年4月29日 下午8:32:50
 * @description 排序字段
 */
public enum SortFieldConstant {
    TIME("update_time"),PV("pv"),ID("id");
    
    private String value;
    
    SortFieldConstant(String value){
	this.value = value;
    }
    
    public String getValue() {
	return value;
    }
    public static SortFieldConstant nameOf(String value) {
	if(value.equals("time")) {
	    return TIME;
	}else if(value.equals("pv")) {
	    return PV;
	}else if(value.equals("id")){
	    return ID;
	}else {
	    return null;
	}
    }
    
    
}

/**
 * 
 */
package cqupt.nmid.home.model;

/**
 * @author MaRong
 * @date 2016年4月9日 下午10:04:09
 * @description 
 */
public enum AuthorityModel {
    USER("user"),ADMIN("admin");
    
    
    AuthorityModel(String value) {
	this.value = value;
    }
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    
}

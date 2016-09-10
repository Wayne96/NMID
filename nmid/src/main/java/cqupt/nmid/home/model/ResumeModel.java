/**
 * 
 */
package cqupt.nmid.home.model;

/**
 * @author MaRong
 * @date 2016年5月14日 下午9:47:33
 * @description 
 */
public class ResumeModel {
    private Integer resumeId;
    private Integer userId;
    private String key;
    private String value;
    public Integer getResumeId() {
        return resumeId;
    }
    public void setResumeId(Integer resumeId) {
        this.resumeId = resumeId;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    
    
}

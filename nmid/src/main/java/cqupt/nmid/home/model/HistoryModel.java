/**
 * 
 */
package cqupt.nmid.home.model;

/**
 * @author MaRong
 * 登录ip记录
 */
public class HistoryModel {
    private Integer id;
    private Integer uid;
    private String ip;
    private String city;
    private Long time;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getUid() {
        return uid;
    }
    public void setUid(Integer uid) {
        this.uid = uid;
    }
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public Long getTime() {
        return time;
    }
    public void setTime(Long time) {
        this.time = time;
    }
    
    
    
}

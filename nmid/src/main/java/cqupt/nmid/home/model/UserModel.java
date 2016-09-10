/**
 * 
 */
package cqupt.nmid.home.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import cqupt.nmid.home.model.group.AddUser;



@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)  
public class UserModel  extends BaseUserModel{
    
    
    
    @NotNull(groups= {AddUser.class})
    @Length(max=20,groups= {AddUser.class})
    private String name;
    
    
   
    @JsonIgnore
    private String sex;
    private String tel;
    
    private String profile;

    private String portrait;
    @NotNull(groups= {AddUser.class})
    private String platform;
    @NotNull(groups= {AddUser.class})
    private String job;
    
    private Long registerTime;
    private Long updateTime;
    private Integer pv;
    private String weibo;
    private String qq;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
   
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getProfile() {
        return profile;
    }
    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getPortrait() {
        return portrait;
    }
    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }
    public String getPlatform() {
        return platform;
    }
    public void setPlatform(String platform) {
        this.platform = platform;
    }
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }
    public Long getRegisterTime() {
        return registerTime;
    }
    public void setRegisterTime(Long registerTime) {
        this.registerTime = registerTime;
    }
    public Long getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
    
    public Integer getPv() {
        return pv;
    }
    public void setPv(Integer pv) {
        this.pv = pv;
    }
    public String getWeibo() {
        return weibo;
    }
    public void setWeibo(String weibo) {
        this.weibo = weibo;
    }
    public String getQq() {
        return qq;
    }
    public void setQq(String qq) {
        this.qq = qq;
    }
    @Override
    public String toString() {
	return "UserModel [name=" + name + ", sex=" + sex + ", tel=" + tel
		+ ", profile=" + profile + ", portrait=" + portrait
		+ ", platform=" + platform + ", job=" + job + ", registerTime="
		+ registerTime + ", updateTime=" + updateTime + ", pv=" + pv
		+ ", weibo=" + weibo + ", qq=" + qq + "]";
    }
   
   
    
    

}

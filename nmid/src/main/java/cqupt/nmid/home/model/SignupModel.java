/**
 * 
 */
package cqupt.nmid.home.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;


/**
 * @author MaRong
 * @date 2016年2月20日 下午4:09:55
 * @description
 */
public class SignupModel {
    private int signup_id;
    @NotNull
    private String name;
    @NotNull
    @Length(max=50)
    private String email;
    @NotNull
    @Length(max=20)
    private String qq;
    @NotNull
    private String platform;
    @NotNull
    @Length(max=50)
    private String phone;
    @NotNull
    private String introduction;
    private String time;
    private String status;
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getPhone() {
	return phone;
    }

    public void setPhone(String phone) {
	this.phone = phone;
    }


    

    public int getSignup_id() {
        return signup_id;
    }

    public void setSignup_id(int signup_id) {
        this.signup_id = signup_id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }


    public String getPlatform() {
	return platform;
    }

    public void setPlatform(String platform) {
	this.platform = platform;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public String toString() {
	return "SignupModel [signup_id=" + signup_id + ", name=" + name
		+ ", email=" + email + ", qq=" + qq + ", platform=" + platform
		+ ", phone=" + phone + ", introduction=" + introduction
		+ ", time=" + time + "]";
    }

    
}

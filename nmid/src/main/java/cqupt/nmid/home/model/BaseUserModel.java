/**
 * 
 */
package cqupt.nmid.home.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import cqupt.nmid.home.model.group.AddUser;
import cqupt.nmid.home.model.group.LoginUser;

/**
 * @author MaRong
 * user的基类
 *
 */
public class BaseUserModel {
    private Integer id;
    
    @NotNull(groups= {AddUser.class,LoginUser.class})
    @Pattern(regexp="^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$",groups= {AddUser.class,LoginUser.class})
    private String email;
    
    
    @NotNull(groups= {AddUser.class,LoginUser.class})
    private String password;
    
    @NotNull(groups= {AddUser.class})
    private String role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
}

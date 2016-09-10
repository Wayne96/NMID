package cqupt.nmid.home.model.json;

import cqupt.nmid.home.model.UserModel;
/**
 * 
 * @author MagicWolf
 * 用户基本信息模型
 *
 */
public class UserBaseModel {
    private int id;
    private String name;
    private String portrait;
    public UserBaseModel() { }
    public UserBaseModel(UserModel user) {
        this.id=user.getId();
        this.name=user.getName();
        this.portrait=user.getPortrait();
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPortrait() {
        return portrait;
    }
    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }
    @Override
    public String toString() {
        return "UserBaseModel [id=" + id + ", name=" + name + ", portrait="
                + portrait + "]";
    }
}

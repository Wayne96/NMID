/**
 * 
 */
package cqupt.nmid.home.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import cqupt.nmid.home.model.group.AddNews;
import cqupt.nmid.home.model.group.AddUser;
import cqupt.nmid.home.model.group.UpdateNews;

/**
 * @author MaRong
 * @date 2016年4月14日 下午4:44:10
 * @description 
 */
public class NewsModel {
    
    private int id;
    @NotNull(groups= {AddNews.class})
    private Long uid;
    
    @NotNull(groups= {AddNews.class})
    private String title;
    @NotNull(groups= {AddNews.class})
    private String content;
    @NotNull(groups= {AddNews.class})
    private String profile;
    
    
    private Integer status;
    
    private Long create_time;
    
    private Integer pv;
    
    private Long update_time;
    @NotNull(groups= {AddNews.class})
    private String illustration;

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public Integer getPv() {
        return pv;
    }


    public void setPv(Integer pv) {
        this.pv = pv;
    }


    public String getIllustration() {
        return illustration;
    }


    public void setIllustration(String illustration) {
        this.illustration = illustration;
    }


    public Long getUid() {
        return uid;
    }



    public void setUid(Long uid) {
        this.uid = uid;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }


    public String getProfile() {
        return profile;
    }


    public void setProfile(String profile) {
        this.profile = profile;
    }


    public Integer getStatus() {
        return status;
    }


    public void setStatus(Integer status) {
        this.status = status;
    }




    public Long getCreate_time() {
        return create_time;
    }


    public void setCreate_time(Long create_time) {
        this.create_time = create_time;
    }


    public Long getUpdate_time() {
        return update_time;
    }


    public void setUpdate_time(Long update_time) {
        this.update_time = update_time;
    }

    
    
    
    
}

/**
 * 
 */
package cqupt.nmid.home.model;

import javax.validation.constraints.NotNull;

import cqupt.nmid.home.model.group.AddProject;
import cqupt.nmid.home.model.group.UpdateNews;

/**
 * @author MaRong
 * @date 2016年5月3日 上午11:45:22
 * @description 
 */
public class ProjectModel {
    
    private Long id;
    @NotNull(groups= {AddProject.class})
    private Long uid;
    @NotNull(groups= {AddProject.class})
    private String title;
    @NotNull(groups= {AddProject.class})
    private String author;
    
    private Long update_time;
    @NotNull(groups= {AddProject.class})
    private String platform ;
   
    @NotNull(groups= {AddProject.class})
    private String profile;
    
    private String cover;
    @NotNull(groups= {AddProject.class})
    private String version;
    
    private Integer status;
    
    private Integer hot;
    private String system;
    
    
    
    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }
    
    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Long update_time) {
        this.update_time = update_time;
    }


    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }


    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
    
}

package cqupt.nmid.home.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
/**
 * 
 * @author MagicWolf
 * 博客模型
 */
@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)  
public class BlogModel {
    @JsonProperty("id")
    private int blogId;
    private String title;
    private String illustartion;
    private int authorId;
    private Long time;
    private int platform;
    private String content;
    private String profile;
    private int pv;
    private Integer state;
    public int getBlogId() {
        return blogId;
    }
    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getIllustartion() {
        return illustartion;
    }
    public void setIllustartion(String illustartion) {
        this.illustartion = illustartion;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public int getPv() {
        return pv;
    }
    public void setPv(int pv) {
        this.pv = pv;
    }
    public Long getTime() {
        return time;
    }
    public void setTime(Long time) {
        this.time = time;
    }
    public String getProfile() {
        return profile;
    }
    public void setProfile(String profile) {
        this.profile = profile;
    }
    public int getAuthorId() {
        return authorId;
    }
    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
    public int getPlatform() {
        return platform;
    }
    public void setPlatform(int platform) {
        this.platform = platform;
    }
    public Integer getState() {
        return state;
    }
    public void setState(Integer state) {
        this.state = state;
    }
    
}

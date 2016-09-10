package cqupt.nmid.home.model.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import cqupt.nmid.home.model.BlogModel;
import cqupt.nmid.home.model.TagModel;
import cqupt.nmid.home.model.UserModel;
/**
 * 博客列表模型
 * @author MagicWolf
 *
 */
@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)
public class BlogListModel {
    @JsonProperty("id")
    private int blogId;
    private String title;
    private String profile;
    private String illustartion;
    private Long time;
    private UserBaseModel author;
    private List<TagModel> tags;
    
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
    public List<TagModel> getTags() {
        return tags;
    }
    public void setTags(List<TagModel> tags) {
        this.tags = tags;
    }
    
    public String getProfile() {
        return profile;
    }
    public void setProfile(String profile) {
        this.profile = profile;
    }
    public Long getTime() {
        return time;
    }
    public void setTime(Long time) {
        this.time = time;
    }
    public String getIllustartion() {
        return illustartion;
    }
    public void setIllustartion(String illustartion) {
        this.illustartion = illustartion;
    }
    
    public UserBaseModel getAuthor() {
        return author;
    }
    public void setAuthor(UserBaseModel author) {
        this.author = author;
    }
    public static BlogListModel valueOf(BlogModel blog,UserModel author,List<TagModel> tags){
        BlogListModel bl=new BlogListModel();
        bl.setBlogId(blog.getBlogId());
        bl.setTitle(blog.getTitle());
        bl.setProfile(blog.getProfile());
        bl.setIllustartion(blog.getIllustartion());
        bl.setTime(blog.getTime());
        bl.setAuthor(new UserBaseModel(author));
        bl.setTags(tags);
        return bl;
    }
}

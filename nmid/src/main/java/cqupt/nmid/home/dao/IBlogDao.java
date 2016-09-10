package cqupt.nmid.home.dao;

import java.util.List;

import cqupt.nmid.home.model.BlogModel;
import cqupt.nmid.home.model.json.HotBlogModel;

public interface IBlogDao {
    /**
     * 得到博客列表
     * @param pageNum 页数
     * @param size 数量
     * @param index index=pageNum*size 
     * @param sortBy 排序依据
     * @param order 排序规则
     * @return
     */
    public List<BlogModel> getBlogList(int size,int offset,String sortBy,String order);
    
    /**
     * 通过id得到博客 
     * @param id
     * @return
     */
    public BlogModel getBlog(int id);
    /**
     * 更新博客
     * @param blog
     * @return
     */
    public int updateBlog(BlogModel blog);
    /**
     * 删除博客
     * @param id
     * @return
     */
    public int deleteBlog(int id);
    
    public int insertBlog(BlogModel blog);
    /**
     * 增加博客访问量一次
     * @param id
     */
    public void increaseBlogPv(int id);
    /**
     * 得到博客数量
     * @return
     */
    public int getBlogNum();
    /**
     * 得到某个标签的博客
     * @param tagId 标签id
     * @param pageNum 页码
     * @param size 每页数量
     * @param index index=pageNum*size 
     * @param sortBy 排序依据
     * @param order 排序方式
     * @return
     */
    public List<BlogModel> getBlogListByTag(int tagId,int pageNum,int size,int offset,String sortBy,String order);
    /**
     * 获得热门博客
     * @param size
     * @return
     */
    public List<HotBlogModel> getTopBlogs(int size);
    
    /**
     * 获得用户推荐博客
     * @param id
     * @param size
     * @return
     */
    public List<HotBlogModel> getUserHotBlogs(int id,int size);
    /**
     * 通过关键字获得博客
     * @param key
     * @return
     */
    public List<BlogModel> getBlogsByKey(String key);
    
}

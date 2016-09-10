package cqupt.nmid.home.service.impl;

import static cqupt.nmid.home.constant.StatusCodeConstant.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cqupt.nmid.home.dao.IBlogDao;
import cqupt.nmid.home.dao.ITagDao;
import cqupt.nmid.home.dao.IUserDao;
import cqupt.nmid.home.model.BlogModel;
import cqupt.nmid.home.model.TagModel;
import cqupt.nmid.home.model.UserModel;
import cqupt.nmid.home.model.json.BlogListModel;
import cqupt.nmid.home.model.json.HotBlogModel;
import cqupt.nmid.home.model.json.PageListJson;
import cqupt.nmid.home.model.json.ResponseFactory;
import cqupt.nmid.home.model.json.ResponseJson;
import cqupt.nmid.home.model.json.ResponseMapJson;
import cqupt.nmid.home.model.json.UserBaseModel;
import cqupt.nmid.home.service.IBlogService;
@Service("blogSerivce")
public class BlogService implements IBlogService{
    
    @Autowired
    @Qualifier("blogMapper")
    private IBlogDao blogDao;
    
    @Autowired
    @Qualifier("tagMapper")
    private ITagDao tagDao;
    
    @Autowired
    @Qualifier("userMapper")
    private IUserDao userDao;
    
    @Autowired
    @Qualifier("repsonseFactory")
    private ResponseFactory factory;
    
    @Override
    public ResponseJson getBlogList(int page,int pageSize,String sortBy,String order) {
        page=page<=0?1:page;
        int num=blogDao.getBlogNum();
        List<BlogModel> blogs=blogDao.getBlogList(pageSize, (page-1)*pageSize,sortBy, order);
        PageListJson<BlogListModel> body=new PageListJson<>(num,page);
        body.setList(createBlogList(blogs));
        ResponseJson json=new ResponseJson(OK);
        json.setBody(body);
        return json;
    }
    @Override
    public ResponseJson getBlog(int id) {
        BlogModel blog=blogDao.getBlog(id);
        UserModel user=userDao.getUserById(blog.getAuthorId());
        List<TagModel> tags=tagDao.getTagsByBlogId(blog.getBlogId());
        ResponseMapJson json=new ResponseMapJson(OK);
        json.put("blog", blog);
        json.put("author", new UserBaseModel(user));
        json.put("tags", tags);
        blogDao.increaseBlogPv(id);
        return json;
    }
    @Override
    public ResponseJson getTopBlogs(int size) {
        List<HotBlogModel> blogs=blogDao.getTopBlogs(size);
        ResponseJson json=new ResponseJson(OK);
        json.setBody(blogs);
        return json;
    }
    
    @Override
    public ResponseJson getUserHotBlogs(int id, int size) {
        List<HotBlogModel> blogs=blogDao.getUserHotBlogs(id, size);
        ResponseJson json=new ResponseJson(OK);
        json.setBody(blogs);
        return json;
    }
    
    @Override
    public ResponseJson search(String key) {
        List<BlogModel> blogs=blogDao.getBlogsByKey("%"+key+"%");
        List<BlogListModel> blogList=new ArrayList<>();
        for (BlogModel blog : blogs) {
            UserModel author=userDao.getUserById(blog.getAuthorId());
            List<TagModel> tags=tagDao.getTagsByBlogId(blog.getBlogId());
            blogList.add(BlogListModel.valueOf(blog, author, tags));
        }
        ResponseJson json=new ResponseJson(OK);
        json.setBody(blogList);
        return json;
    }
    
    @Override
    public ResponseJson updateBlog(int id, BlogModel blog) {
        blog.setBlogId(id);
        blogDao.updateBlog(blog);
        return factory.getResponseJsonInstance(CREATED);
    }
    
    @Override
    public ResponseJson deleteBlog(int id) {
        blogDao.deleteBlog(id);
        return factory.getResponseJsonInstance(GONE);
    }
    @Override
    public ResponseJson insertBlog(BlogModel blog) {
        blogDao.insertBlog(blog);
        ResponseMapJson json=factory.getResponseMapJsonInstance(CREATED);
        json.put("url", "/blogs/"+blog.getBlogId());
        return json;
    }
    //======================private help method========================
    private List<BlogListModel> createBlogList(List<BlogModel> blogs){
        List<BlogListModel> list=new ArrayList<>();
        for (BlogModel blog : blogs) {
            UserModel author=userDao.getUserById(blog.getAuthorId());
            List<TagModel> tags=tagDao.getTagsByBlogId(blog.getBlogId());
            list.add(BlogListModel.valueOf(blog, author, tags));
        }
        return list;
    }
    
}

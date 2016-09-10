package cqupt.nmid.home.service.impl;

import static cqupt.nmid.home.constant.StatusCodeConstant.OK;

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
import cqupt.nmid.home.model.json.PageListJson;
import cqupt.nmid.home.model.json.ResponseJson;
import cqupt.nmid.home.service.ITagService;

@Service("tagSerivce")
public class TagService implements ITagService{
    
    @Autowired
    @Qualifier("tagMapper")
    private ITagDao tagDao;
    
    @Autowired
    @Qualifier("blogMapper")
    private IBlogDao blogDao;
    
    @Autowired
    @Qualifier("userMapper")
    private IUserDao userDao;
    
    
    @Override
    public ResponseJson getFrequentlyTags(int size) {
        List<TagModel> tags=tagDao.getFrequentlyTags(size);
        ResponseJson json=new ResponseJson(OK);
        json.setBody(tags);
        return json;
    }
    @Override
    public ResponseJson getBlogListByTag(int tagId,int page,int pageSize,String sortBy,String order) {
        page=page<=0?0:page-1;
        TagModel tag=tagDao.getTagById(tagId);
        List<BlogModel> blogs=blogDao.getBlogListByTag(tagId,page, pageSize, page*pageSize,sortBy, order);
        PageListJson<BlogListModel> body=new PageListJson<>(tag.getNum(),page);
        body.setList(createBlogList(blogs));
        ResponseJson json=new ResponseJson(OK);
        json.setBody(body);
        return json;
    }
    //=====================private method=====================================
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

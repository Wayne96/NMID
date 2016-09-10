package cqupt.nmid.home.service;

import cqupt.nmid.home.model.BlogModel;
import cqupt.nmid.home.model.json.ResponseJson;

public interface IBlogService {
    public ResponseJson getBlogList(int page,int pageSize,String sortBy,String order);
    public ResponseJson getBlog(int id);
    public ResponseJson updateBlog(int id,BlogModel blog);
    public ResponseJson deleteBlog(int id);
    public ResponseJson insertBlog(BlogModel blog);
    public ResponseJson getTopBlogs(int size);
    public ResponseJson getUserHotBlogs(int id,int size);
    public ResponseJson search(String key);

}

package cqupt.nmid.home.dao.impl.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cqupt.nmid.home.dao.IBlogDao;
import cqupt.nmid.home.model.BlogModel;
import cqupt.nmid.home.model.json.HotBlogModel;

/**
 * 由mybatis自动映射,继承自{@code IBlogDao},使用时使用IBlogDao
 * 当参数映射错误时，可以覆盖父类方法通过注解指定参数
 * @author MagicWolf
 *
 */
public interface BlogMapper extends IBlogDao{
    @Override
    public List<BlogModel> getBlogList(@Param("size") int size,@Param("offset") int offset,@Param("sort_by")String sortBy,@Param("order")String order);
    @Override
    public List<BlogModel> getBlogListByTag(@Param("tagId")int tagId,@Param("pageNum") int pageNum,@Param("size") int size,@Param("index") int index,@Param("sortBy")String sortBy,@Param("order")String order);
    @Override
    public List<HotBlogModel> getUserHotBlogs(@Param("id")int id,@Param("size")int size);
}

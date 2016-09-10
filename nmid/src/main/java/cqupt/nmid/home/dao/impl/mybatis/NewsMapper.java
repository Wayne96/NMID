/**
 * 
 */
package cqupt.nmid.home.dao.impl.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cqupt.nmid.home.constant.StatusConstant;
import cqupt.nmid.home.constant.sql.SortFieldConstant;
import cqupt.nmid.home.dao.INewsDao;
import cqupt.nmid.home.model.NewsModel;

/**
 * @author MaRong
 * @date 2016年5月10日 下午3:35:04
 * @description 
 */
@Repository("newsMapper")
public interface NewsMapper extends INewsDao{
    
    @Override
    public int addNews(NewsModel news);
    
    @Override
    public List<Map<String,Object>> getNewsByUser(@Param("uid") int uid);
    
    @Override
    public int deleteNews(@Param("newsId")int newsId,@Param("uid") int uid);
    
    @Override
    public int updateNews(NewsModel news);
    
    public int checkNews(StatusConstant status,int newsId);
    
    @Override
    public List<NewsModel> getPublicNews(@Param("offset") int offset, @Param("size") int size,@Param("sort_by")String sortBy,@Param("order")String order);
    @Override
    public Map<String,Object> getNewsById(@Param("id") int id);
    @Override
    public Integer getNumOfNews();
}

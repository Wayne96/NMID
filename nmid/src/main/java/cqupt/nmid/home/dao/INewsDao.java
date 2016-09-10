/**
 * 
 */
package cqupt.nmid.home.dao;

import java.util.List;
import java.util.Map;

import cqupt.nmid.home.constant.StatusConstant;
import cqupt.nmid.home.constant.sql.SortFieldConstant;
import cqupt.nmid.home.model.NewsModel;

/**
 * @author MaRong
 * @date 2016年4月14日 下午6:05:09
 * @description 
 */
public interface INewsDao {
    public int addNews(NewsModel news);
    
    public List<Map<String,Object>> getNewsByUser(int uid);
    
    public int deleteNews(int newsId,int uid);
    
    public int updateNews(NewsModel news);
    
    public int checkNews(StatusConstant status,int newsId);
    
    public List<NewsModel> getPublicNews(int offset,int size,String sort_by,String order);
    
    public Integer getNumOfNews();
    
    public Map<String,Object> getNewsById(int id);
}

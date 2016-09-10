/**
 * 
 */
package cqupt.nmid.home.service;

import cqupt.nmid.home.constant.StatusConstant;
import cqupt.nmid.home.constant.sql.OrderFieldConstant;
import cqupt.nmid.home.constant.sql.SortFieldConstant;
import cqupt.nmid.home.model.NewsModel;
import cqupt.nmid.home.model.json.ResponseJson;

/**
 * @author MaRong
 * @date 2016年4月14日 下午5:46:48
 * @description 
 */
public interface INewsService {
    
    public ResponseJson addNews(NewsModel news);
    
    public ResponseJson getNewsByUser(int uid);
    
    public ResponseJson deleteNews(int id,int uid);
    
    public ResponseJson updateNews(NewsModel news);
    
    public ResponseJson checkNews(StatusConstant stauts,int newsId);
    
    public ResponseJson getPublicNews(SortFieldConstant sortType,int page,int pageSize);
    
    public ResponseJson getNewsById(int newsId);
    
    public ResponseJson getNumOfNews();
}

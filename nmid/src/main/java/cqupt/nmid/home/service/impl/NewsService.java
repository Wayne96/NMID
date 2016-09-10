/**
 * 
 */
package cqupt.nmid.home.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cqupt.nmid.home.constant.StatusCodeConstant;
import cqupt.nmid.home.constant.StatusConstant;
import cqupt.nmid.home.constant.sql.SortFieldConstant;
import cqupt.nmid.home.dao.INewsDao;
import cqupt.nmid.home.dao.IUtilDao;
import cqupt.nmid.home.model.NewsModel;
import cqupt.nmid.home.model.json.NewsListJson;
import cqupt.nmid.home.model.json.ResponseJson;
import cqupt.nmid.home.service.INewsService;
import cqupt.nmid.home.util.TimeUtil;

/**
 * @author MaRong
 * @date 2016年4月14日 下午5:59:53
 * @description
 */

@Service("newsService")
public class NewsService implements INewsService {

    @Autowired
    @Qualifier("newsMapper")
    private INewsDao newsDao;
    
    @Autowired
    private IUtilDao utilDao;

    @Override
    public ResponseJson addNews(NewsModel news) {
	ResponseJson response;
	Long epoch = TimeUtil.getTimestamp();
	news.setStatus(StatusConstant.CREATE.getValue());
	news.setCreate_time(epoch);
	news.setUpdate_time(epoch);
	newsDao.addNews(news);
	int newsId = news.getId();
	if (newsId > 0) {
	    response = new ResponseJson(StatusCodeConstant.OK);
	    response.setBody(newsId);

	} else {
	    response = new ResponseJson(
		    StatusCodeConstant.INTERNAL_SERVER_ERROR);
	    response.setBody(-1);
	}

	return response;

    }

    @Override
    public ResponseJson getNewsByUser(int uid) {
	List<Map<String, Object>> result = newsDao.getNewsByUser(uid);
	ResponseJson response;
	if (result.size() > 0) {
	    response = new ResponseJson(StatusCodeConstant.OK);
	    response.setBody(result);

	} else {
	    response = new ResponseJson(
		    StatusCodeConstant.INTERNAL_SERVER_ERROR);
	}

	return response;
    }

    @Override
    public ResponseJson deleteNews(int id, int uid) {
    ResponseJson response;
    boolean flag = newsDao.deleteNews(id, uid)==0;

    if (flag) {
        response = new ResponseJson(StatusCodeConstant.OK);
    } else {
        response = new ResponseJson(
            StatusCodeConstant.INTERNAL_SERVER_ERROR);
    }
    return response;
    }

    @Override
    public ResponseJson updateNews(NewsModel news) {
    ResponseJson response;
    news.setUpdate_time(TimeUtil.getTimestamp());
    boolean flag = newsDao.updateNews(news)==0;
    if (flag) {
        response = new ResponseJson(StatusCodeConstant.OK);
    } else {
        response = new ResponseJson(
            StatusCodeConstant.INTERNAL_SERVER_ERROR);
    }
    return response;
    }

    @Override
    public ResponseJson checkNews(StatusConstant status, int newsId) {
    ResponseJson response;
    if (status == null) {
        response = new ResponseJson(StatusCodeConstant.INVALID_REQUEST);
    } else {
        boolean flag = newsDao.checkNews(status, newsId)==0;
        if (flag) {
        response = new ResponseJson(StatusCodeConstant.OK);
        response.setBody(newsId);
        } else {
            throw new RuntimeException("数据库错误");
        }
    }

	return response;
    }

    @Override
    public ResponseJson getPublicNews(SortFieldConstant sortType, int page,int pageSize) {
	ResponseJson response ;
	
	List<NewsModel> result = newsDao.getPublicNews( (page-1)*pageSize,pageSize,sortType.getValue(),"desc");
	if(result.size() == 0) {
	    return new ResponseJson(StatusCodeConstant.INTERNAL_SERVER_ERROR);
	}else {
	    response = new ResponseJson(StatusCodeConstant.OK);
	    NewsListJson newsList = new NewsListJson();
	    newsList.setList(result);
	    newsList.setPage(page);
	    newsList.setNum(newsDao.getNumOfNews());
	    response.setBody(newsList);
	}
	
	return response;
    }

  
    @Override
    public ResponseJson getNumOfNews() {
	ResponseJson response;
	int num = newsDao.getNumOfNews();
	if(num> 0) {
	    response = new ResponseJson(StatusCodeConstant.OK);
	    response.setBody(num);
	}else {
	    response = new ResponseJson(StatusCodeConstant.INTERNAL_SERVER_ERROR);
	}
	return response;
    }

    @Override
    public ResponseJson getNewsById(int id) {
	ResponseJson response;
	Map<String,Object> news = newsDao.getNewsById(id);
	if(news == null) {
	    response = new ResponseJson(StatusCodeConstant.INVALID_REQUEST);
	}else {
	    response = new ResponseJson(StatusCodeConstant.OK);
	    
	    //加关注度
	    utilDao.addPv("nmid_news", id, "id");
	    response.setBody(news);
	    
	  
	    
	}
	return response;		
	
    }

}

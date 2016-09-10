/**
 * 
 */
package cqupt.nmid.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cqupt.nmid.home.constant.StatusConstant;
import cqupt.nmid.home.constant.sql.OrderFieldConstant;
import cqupt.nmid.home.constant.sql.SortFieldConstant;
import cqupt.nmid.home.model.NewsModel;
import cqupt.nmid.home.model.UserModel;
import cqupt.nmid.home.model.group.AddNews;
import cqupt.nmid.home.model.group.LoginUser;
import cqupt.nmid.home.model.group.UpdateNews;
import cqupt.nmid.home.model.json.ResponseJson;
import cqupt.nmid.home.service.INewsService;
import cqupt.nmid.home.util.LogUtil;

/**
 * @author MaRong
 * @date 2016年4月14日 下午3:41:52
 * @description 
 */
@Controller
@RequestMapping(value="/news")
public class NewsController {
    
    @Autowired
    private INewsService newsService;
    
   /* 
    * 获取具体的单条新闻
    * 
    */
    @RequestMapping(value="/{newsId}")
    @ResponseBody
    public ResponseJson getNewsById(@PathVariable("newsId") int newsId) {
	return newsService.getNewsById(newsId);
    }
    
    
    
    /*
     * 获取新闻的公共接口，默认按时间排序
     * 
     * */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public ResponseJson getNews(@RequestParam(value="page",defaultValue="1",required=false) int page,@RequestParam(value ="sort_by",defaultValue="time",required=false) String sortBy,@RequestParam(value="page_size",defaultValue="16",required=false) int pageSize) {
	return newsService.getPublicNews(SortFieldConstant.nameOf(sortBy), page,pageSize);
    }
    
    //------------------内部管理接口---------------------------
    
    
    /* 
     * 获取一个用户的所有新闻
     * 
     */
    @ResponseBody
    @RequestMapping("/user/{uid}")
    public ResponseJson getNewsByUser(@PathVariable("uid") int uid) {
	return newsService.getNewsByUser(uid);
    }
    
    /**
     * 
     * 删除新闻
     * @param newsId
     * @param uid
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/{newsId}",method=RequestMethod.DELETE)
    public ResponseJson delete(@PathVariable("newsId") int newsId,@RequestParam(value="uid",required=false) int uid) {
	return newsService.deleteNews(newsId, uid);
    }
    /**
     * 
     * @param news
     * @return
     */
    
    @ResponseBody
    @RequestMapping(value="/{newsId}",method=RequestMethod.PUT)
    public ResponseJson update(@RequestBody @Validated({UpdateNews.class})NewsModel news,@PathVariable("newsId") int newsId) {
	news.setId(newsId);
	return newsService.updateNews(news);
    }
    
    @ResponseBody
    @RequestMapping(method=RequestMethod.POST)
    public ResponseJson addNews(@RequestBody @Validated({AddNews.class}) NewsModel news) {
	return newsService.addNews(news);
    }
    
    @ResponseBody
    @RequestMapping("/check")
    public ResponseJson check(@RequestParam("status") int status,@RequestParam("id") int newsId) {
	return newsService.checkNews(StatusConstant.valueOf(status), newsId);
    }
    
}

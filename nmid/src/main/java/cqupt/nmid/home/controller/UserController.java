/**
 * 
 */
package cqupt.nmid.home.controller;


import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cqupt.nmid.home.constant.sql.SortFieldConstant;
import cqupt.nmid.home.dao.IUserDao;
import cqupt.nmid.home.model.BaseUserModel;
import cqupt.nmid.home.model.NewsModel;
import cqupt.nmid.home.model.UserModel;
import cqupt.nmid.home.model.group.AddNews;
import cqupt.nmid.home.model.group.AddUser;
import cqupt.nmid.home.model.group.LoginUser;
import cqupt.nmid.home.model.json.ResponseJson;
import cqupt.nmid.home.service.IBlogService;
import cqupt.nmid.home.service.IHistoryService;
import cqupt.nmid.home.service.IResumeService;
import cqupt.nmid.home.service.IUserService;
import cqupt.nmid.home.util.HtmlUtil;
import cqupt.nmid.home.service.IWorkService;

/**
 * @author MaRong
 * @date 2016年3月11日 下午6:24:00
 * @description 
 */
@Controller
@RequestMapping(value = "/users")
public class UserController {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    
    @Autowired
    private IUserService userService;
    @Autowired
    private IResumeService resumeService;
   
    @Autowired
    private IHistoryService historyService;
    
    @Autowired
    private IUserDao userDao;
    
    @Autowired
    @Qualifier("blogSerivce") 
    private IBlogService blogSerivce;
    
    @Autowired
    @Qualifier("workSerivce") 
    private IWorkService workSerivce;
    
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseJson getUserList(@RequestParam(value="page",defaultValue="1",required=false) int page,@RequestParam(value ="page_size",defaultValue="16") int size,@RequestParam(value="sort_by",defaultValue="id") String sortBy ) {
	return userService.getUserList(page, size,SortFieldConstant.nameOf(sortBy));
    }
    
    
    @RequestMapping(value="/{id}" ,method= RequestMethod.GET)
    @ResponseBody
    public ResponseJson getUserById(@PathVariable(value="id") int id) {
	return userService.getUserById(id);
	
    }
    
    /**
     * @author MagicWolf
     * 用户热门博客
     */
    @RequestMapping(value="/{id}/blogs/hot" ,method= RequestMethod.GET)
    public @ResponseBody ResponseJson getUserHotBlogs(@PathVariable(value="id") int id,@RequestParam(value="size",defaultValue="10",required=false) int size) {
        return blogSerivce.getUserHotBlogs(id, size);
    }
    
    /**
     * @author MagicWolf
     * 个人作品推荐
     */
    @RequestMapping(value="/{id}/works/hot" ,method= RequestMethod.GET)
    public @ResponseBody ResponseJson getUserWorks(@PathVariable(value="id") int id,@RequestParam(value="size",defaultValue="4",required=false) int size) {
        return workSerivce.getUserHotWorks(id, size);
    }
    /**
     * 用户所有作品 
     */
    @RequestMapping(value="/{id}/works",method = RequestMethod.GET)
    public @ResponseBody ResponseJson getUserWorks(@PathVariable(value="id") int id,@RequestParam(value="page",defaultValue="1",required=false) int page,@RequestParam(value="page_size",defaultValue="10",required=false) int pageSize,@RequestParam(value="sort_by",defaultValue="id",required=false) String sortBy,@RequestParam(value="order",defaultValue="desc",required=false) String order){
        return workSerivce.getUserWork(id,page, pageSize, sortBy, order);
    }
    
    
    @RequestMapping(value="/{id}/resumes",method=RequestMethod.GET)
    @ResponseBody
    public ResponseJson getResumeByUser(@PathVariable("id") int userId) {
	return resumeService.getResumeByUser(userId);
    }
    @RequestMapping(value="/{id}/history",method=RequestMethod.POST)
    @ResponseBody
    public ResponseJson getUserHistory(@PathVariable("id") int userId) {
	return historyService.getHistoryByUser(userId);
    }
    
    //----------------------------用户管理模块-------------------------
    
    /*
     * 添加用户
     * 
     * */
    
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseJson addUser(@Validated({AddUser.class})  UserModel user ) {
	return userService.addUser(user);
    }
    
    @RequestMapping(value="/login",method=RequestMethod.POST)
    @ResponseBody
    public ResponseJson login(@RequestBody @Validated({LoginUser.class}) BaseUserModel user,HttpServletResponse response) throws NoSuchAlgorithmException, IOException{
	return userService.login(user,response);
	
    }
    
    @RequestMapping(value="/changePassWord",method = RequestMethod.POST)
    @ResponseBody
    public ResponseJson changePassWord(@RequestParam("id") int id,@RequestParam("old") String oldPassWord,@RequestParam("new") String newPassWord) {
	return userService.changePassWord( id, oldPassWord, newPassWord);
    }
    
    @RequestMapping(value="/{uid}",method=RequestMethod.DELETE)
    @ResponseBody
    public ResponseJson deleteUser(@PathVariable("uid") int uid) {
	return userService.deleteUser(uid);
    }
    
    /*@RequestMapping(value="/{uid}",method=RequestMethod.PUT)
    @ResponseBody
    public ResponseJson updateUser(UserModel user) {
	
    }*/
}

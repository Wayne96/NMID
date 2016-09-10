/**
 * 
 */
package cqupt.nmid.home.service.impl;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cqupt.nmid.home.constant.StatusCodeConstant;
import cqupt.nmid.home.constant.sql.OrderFieldConstant;
import cqupt.nmid.home.constant.sql.SortFieldConstant;
import cqupt.nmid.home.dao.IUserDao;
import cqupt.nmid.home.dao.IUtilDao;
import cqupt.nmid.home.model.AuthorityModel;
import cqupt.nmid.home.model.BaseUserModel;
import cqupt.nmid.home.model.UserModel;
import cqupt.nmid.home.model.json.ResponseJson;
import cqupt.nmid.home.service.IUserService;
import cqupt.nmid.home.util.AESCodec;
import cqupt.nmid.home.util.EncryptUtil;
import cqupt.nmid.home.util.ResponseHandelUtil;
import cqupt.nmid.home.util.TimeUtil;

/**
 * @author MaRong
 * @date 2016年3月11日 下午6:46:20
 * @description
 */
@Service("userService")
public class UserService implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private IUtilDao utilDao;
    @Autowired
    private CacheService cacheService;

    @Override
    public ResponseJson addUser(UserModel user) {

	ResponseJson response;

	Long epoch = TimeUtil.getTimestamp();
	user.setRegisterTime(epoch);
	user.setUpdateTime(epoch);

	user.setPassword(EncryptUtil.MD5Encrypt(user.getPassword()));

	int id = userDao.addUser(user);

	if (id <= 0) {
	    response = new ResponseJson(
		    StatusCodeConstant.INTERNAL_SERVER_ERROR);
	} else {
	    response = new ResponseJson(StatusCodeConstant.CREATED);
	    response.setBody(id);
	}
	return response;
    }

    @Override
    public ResponseJson login(BaseUserModel user,HttpServletResponse httpResponse)
	    throws NoSuchAlgorithmException, IOException {

	ResponseJson response;

	int uid = userDao.login(user.getEmail(),
		EncryptUtil.MD5Encrypt(user.getPassword()));
	String auth = userDao.getUserAuthority(uid);

	if (uid > 0
		&& (auth.equals(AuthorityModel.USER.getValue()) || auth
			.equals(AuthorityModel.ADMIN.getValue()))) {
	    response = new ResponseJson(StatusCodeConstant.OK);


	    // 需要发放token
	    String token = AESCodec.initkey();
	    cacheService.addToCache("tokenCache", token, user);
	    
	    //写入cookies
	    Cookie cookie = new Cookie("token",token);
	    httpResponse.addCookie(cookie);
	    cookie.setMaxAge(1800);
	    httpResponse.flushBuffer();
	    Map<String,Object> userInfo = new HashMap<String,Object>();
	    userInfo.put("id", uid);
	    userInfo.put("role", auth);
	    //userInfo.put("token", token);
	    response.setBody(userInfo);

	} else {
	    response = new ResponseJson(StatusCodeConstant.INVALID_REQUEST);
	}

	return response;
    }

    @Override
    public ResponseJson changePassWord(int id, String oldPassWord,
	    String newPassWord) {
	ResponseJson response;
	
	int result = userDao.changePassWord(id, EncryptUtil.MD5Encrypt(oldPassWord), EncryptUtil.MD5Encrypt(newPassWord));
	
	response = ResponseHandelUtil.handleIntCondition(1, result, StatusCodeConstant.INVALID_REQUEST);

	return response;
    }

    @Override
    public ResponseJson getUserList(int page, int size, SortFieldConstant sortBy) {
	ResponseJson response;
	if ((sortBy != SortFieldConstant.ID)
		&& (sortBy != SortFieldConstant.PV) || page < 1 || size < 1) {
	    return new ResponseJson(StatusCodeConstant.INVALID_REQUEST);
	}
	List<UserModel> users = userDao.getUserList((page - 1) * size, size,
		"desc", sortBy.getValue());
	if (users.size() == 0) {
	    response = new ResponseJson(
		    StatusCodeConstant.INTERNAL_SERVER_ERROR);
	} else {
	    Map<String, Object> userList = new HashMap<String, Object>();
	    int total = userDao.getUserNum();
	    response = new ResponseJson(StatusCodeConstant.OK);
	    userList.put("num", total);
	    userList.put("page", page);
	    userList.put("list", users);
	    response.setBody(userList);
	}
	return response;
    }

    @Override
    public ResponseJson getUserById(int uid) {
	ResponseJson response;

	if (uid < 1) {
	    return new ResponseJson(StatusCodeConstant.INVALID_REQUEST);
	}

	UserModel user = userDao.getUserById(uid);
	if (user == null) {
	    response = new ResponseJson(
		    StatusCodeConstant.INTERNAL_SERVER_ERROR);
	} else {

	    response = new ResponseJson(StatusCodeConstant.OK);
	    //添加人气
	    utilDao.addPv("nmid_user", uid, "id");
	    response.setBody(user);
	    
	   
	    
	}
	return response;
    }

    /* 删除user
     * 
     */
    @Override
    public ResponseJson deleteUser(int uid) {
	int result = userDao.deleteUser(uid);
	return ResponseHandelUtil.handleIntCondition(1, result, StatusCodeConstant.INTERNAL_SERVER_ERROR);
    }

}

/**
 * 
 */
package cqupt.nmid.home.service;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletResponse;

import cqupt.nmid.home.constant.sql.OrderFieldConstant;
import cqupt.nmid.home.constant.sql.SortFieldConstant;
import cqupt.nmid.home.model.BaseUserModel;
import cqupt.nmid.home.model.UserModel;
import cqupt.nmid.home.model.json.ResponseJson;

/**
 * @author MaRong
 * @date 2016年3月11日 下午6:46:06
 * @description 
 */
public interface IUserService {
    public ResponseJson deleteUser(int uid);
    
    public ResponseJson addUser(UserModel user);
    
    public ResponseJson login(BaseUserModel user,HttpServletResponse response) throws NoSuchAlgorithmException, IOException;
    
    public ResponseJson changePassWord(int uid,String oldPassWord,String newPassWord);
    
    public ResponseJson getUserList(int page,int size,SortFieldConstant sortBy);
    
    public ResponseJson getUserById(int uid);
}

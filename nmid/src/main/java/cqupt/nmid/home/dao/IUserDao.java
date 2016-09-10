/**
 * 
 */
package cqupt.nmid.home.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cqupt.nmid.home.model.UserModel;

/**
 * @author MaRong
 * @date 2016年3月11日 下午6:49:25
 * @description 
 */
public interface IUserDao {
    public int deleteUser(int uid);
    
    public int addUser(UserModel User);
    
    public int login(String email,String passWord);
    
    public int changePassWord(int id,String oldPassWord,String newPassWord );
    
    public UserModel getUserById(@Param("id") int id);
    
    public List<UserModel> getUserList(@Param("offset") int offset,@Param("size")  int size,@Param("orderBy") String orderBy,@Param("sortBy") String sortBy);
    
    public Integer getUserNum();
    
    public String getUserAuthority(int uid);
}

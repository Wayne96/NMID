/**
 * 
 */
package cqupt.nmid.home.dao.impl.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cqupt.nmid.home.dao.IUserDao;
import cqupt.nmid.home.model.UserModel;

/**
 * @author MaRong
 * @date 2016年5月10日 下午4:26:09
 * @description 
 */
public interface UserMapper extends IUserDao{
    @Override
    public int addUser(UserModel User);
    @Override
    public UserModel getUserById(@Param("id") int id);
    @Override
    public List<UserModel> getUserList(@Param("offset") int offset,@Param("size")  int size,@Param("orderBy") String orderBy,@Param("sortBy") String sortBy);
    @Override
    public Integer getUserNum();
    @Override
    public String getUserAuthority(@Param("uid") int uid);
    @Override
    public int  login(@Param("email") String email,@Param("passWord")String passWord);
    @Override
    public int changePassWord(@Param("uid") int uid,@Param("old") String oldPassWord, @Param("new") String newPassWord );
    @Override
    public int deleteUser(@Param("uid") int uid);
}

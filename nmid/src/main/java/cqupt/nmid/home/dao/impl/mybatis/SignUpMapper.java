/**
 * 
 */
package cqupt.nmid.home.dao.impl.mybatis;

import org.springframework.stereotype.Repository;

import cqupt.nmid.home.dao.ISignUpDao;
import cqupt.nmid.home.model.SignupModel;

/**
 * @author MaRong
 *
 */
@Repository("signUpMapper")
public interface SignUpMapper  extends ISignUpDao{
    @Override
    public int signUp(SignupModel signUp);
}

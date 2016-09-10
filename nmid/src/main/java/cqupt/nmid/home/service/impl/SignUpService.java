/**
 * 
 */
package cqupt.nmid.home.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cqupt.nmid.home.constant.StatusCodeConstant;
import cqupt.nmid.home.dao.ISignUpDao;
import cqupt.nmid.home.model.SignupModel;
import cqupt.nmid.home.model.json.ResponseJson;
import cqupt.nmid.home.util.ResponseHandelUtil;
import cqupt.nmid.home.util.TimeUtil;

/**
 * @author MaRong
 *
 */
@Service("signUpService")
public class SignUpService {
    @Autowired
    private ISignUpDao signUpDao;
    public ResponseJson signUp(SignupModel model) {
	model.setTime(TimeUtil.getNowTime());
	int result = signUpDao.signUp(model);
	return ResponseHandelUtil.handleIntCondition(1, result, StatusCodeConstant.INTERNAL_SERVER_ERROR);
    }
}

/**
 * 
 */
package cqupt.nmid.home.service;

import cqupt.nmid.home.model.SignupModel;
import cqupt.nmid.home.model.json.ResponseJson;

/**
 * @author MaRong
 * @date 2016年2月20日 下午6:50:08
 * @description 
 */
public interface ISignUpService {
    public ResponseJson signUp(SignupModel signUp);
}

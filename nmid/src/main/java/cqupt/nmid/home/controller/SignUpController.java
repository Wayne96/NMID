/**
 * 
 */
package cqupt.nmid.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cqupt.nmid.home.model.SignupModel;
import cqupt.nmid.home.model.json.ResponseJson;
import cqupt.nmid.home.service.impl.SignUpService;

/**
 * @author Marong
 *
 */

@Controller()
public class SignUpController {
    @Autowired
    private SignUpService signUpService;
    
    @RequestMapping(value="/signUp",method=RequestMethod.POST)
    @ResponseBody
    public ResponseJson signUp(@RequestBody SignupModel model){
	return signUpService.signUp(model);
    }
}

/**
 * 
 */
package cqupt.nmid.home.controller;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cqupt.nmid.home.model.ResumeModel;
import cqupt.nmid.home.model.json.ResponseJson;
import cqupt.nmid.home.service.IResumeService;

/**
 * @author MaRong
 * @date 2016年5月18日 上午9:09:06
 * @description 
 */
@Controller
@RequestMapping(value="/resume")
public class ResumeController {
    
    @Autowired
    private IResumeService resumeService;
   
    
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    @ResponseBody
    public ResponseJson deleteResume(@PathVariable("id") int resumeId,@RequestParam("uid") int userId) {
	return resumeService.deleteResume(resumeId,userId);
    }
    
    @RequestMapping(method=RequestMethod.POST)
    @ResponseBody
    public ResponseJson addResume(@RequestBody List<ResumeModel> resumeList) {
	
	return resumeService.addResume(resumeList);
    }
    
    @RequestMapping(value="/{id}",method=RequestMethod.PUT)
    @ResponseBody
    public ResponseJson updateResume(@PathVariable("id") int resumeId,@RequestBody String resume) {
	
	
	return resumeService.updateResume(resumeId,resume);
    }
    
   
}

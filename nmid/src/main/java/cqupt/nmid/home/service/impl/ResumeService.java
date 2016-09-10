/**
 * 
 */
package cqupt.nmid.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import cqupt.nmid.home.constant.StatusCodeConstant;
import cqupt.nmid.home.dao.IResumeDao;
import cqupt.nmid.home.model.ResumeModel;
import cqupt.nmid.home.model.json.ResponseJson;
import cqupt.nmid.home.service.IResumeService;

/**
 * @author MaRong
 * @date 2016年5月18日 上午10:25:31
 * @description 
 */
@Service("resumeService")
public class ResumeService implements IResumeService{

    @Autowired
    private IResumeDao resumeDao;
    
    
    private Gson gson = new Gson();
    @Override
    public ResponseJson getResumeByUser(int userId) {
	ResponseJson response;
	if(userId < 1 || userId >= Integer.MAX_VALUE) {
	    return new ResponseJson(StatusCodeConstant.INVALID_REQUEST);
	}
	
	
	List<ResumeModel> resumeList = resumeDao.getResumeById(userId);
	response = new ResponseJson(StatusCodeConstant.OK);
	response.setBody(resumeList);
	
	return response;
    }

    
    @Override
    public ResponseJson addResume(List<ResumeModel> resumeList) {
	
	ResponseJson responseJson;
	int rows = resumeDao.addResume(resumeList);
	
	if(rows == resumeList.size()) {
	    responseJson = new ResponseJson(StatusCodeConstant.OK);
	}else {
	    responseJson  = new ResponseJson(StatusCodeConstant.INTERNAL_SERVER_ERROR);
	}
	
	return responseJson;
	
	
    }



    
    @Override
    public ResponseJson deleteResume(int resumeId, int userId) {
	
	int result = resumeDao.deleteResume(resumeId, userId);
	if(result == 1) {
	    return new ResponseJson(StatusCodeConstant.OK);
	}else {
	    return new ResponseJson(StatusCodeConstant.INTERNAL_SERVER_ERROR);
	}
    }


    @Override
    public ResponseJson updateResume(int resumeId, String resume) {
	ResumeModel resumeModel = gson.fromJson(resume, ResumeModel.class);
	resumeModel.setResumeId(resumeId);
	int resultCount = resumeDao.updateResume(resumeModel);
	
	if(resultCount == 1) {
	    return new ResponseJson(StatusCodeConstant.OK);
	}else {
	    return new ResponseJson(StatusCodeConstant.INTERNAL_SERVER_ERROR);
	}
    }

}

/**
 * 
 */
package cqupt.nmid.home.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cqupt.nmid.home.constant.StatusCodeConstant;
import cqupt.nmid.home.dao.IHistoryDao;
import cqupt.nmid.home.model.HistoryModel;
import cqupt.nmid.home.model.json.ResponseJson;
import cqupt.nmid.home.service.IHistoryService;
import cqupt.nmid.home.util.ResponseHandelUtil;
import cqupt.nmid.home.util.TimeUtil;

/**
 * @author MaRong
 *
 */

@Service("historyService")
public class HistoryService implements IHistoryService{
    
    @Autowired
    private IHistoryDao historyDao;

    @Override
    public ResponseJson addHistory(int uid, HttpServletRequest request) {
	String ip = request.getRemoteAddr();
	
	HistoryModel history = new HistoryModel();
	history.setIp(ip);
	history.setUid(uid);
	history.setTime(TimeUtil.getTimestamp());
	
	int result = historyDao.addHistory(history);
	return ResponseHandelUtil.handleIntCondition(1, result, StatusCodeConstant.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseJson getHistoryByUser(int uid) {
	ResponseJson response ;
	
	List<HistoryModel> historyList = historyDao.getHistoryByUser(uid);
	if(historyList.size() > 0) {
	    response = new ResponseJson(StatusCodeConstant.OK);
	    response.setBody(historyList);
	}else {
	    response = new ResponseJson(StatusCodeConstant.INTERNAL_SERVER_ERROR);
	}
	return response;
    }
    
}

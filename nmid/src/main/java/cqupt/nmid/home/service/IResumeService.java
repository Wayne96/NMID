/**
 * 
 */
package cqupt.nmid.home.service;

import java.util.List;

import cqupt.nmid.home.model.ResumeModel;
import cqupt.nmid.home.model.json.ResponseJson;

/**
 * @author MaRong
 * @date 2016年5月18日 上午10:25:20
 * @description 
 */
public interface IResumeService {
    public ResponseJson getResumeByUser(int userId);
    
    
    public ResponseJson addResume(List<ResumeModel> resumeList);
    
    public ResponseJson updateResume(int resumeId,String resume);
    
    public ResponseJson deleteResume(int resumeId,int userId);
    
}

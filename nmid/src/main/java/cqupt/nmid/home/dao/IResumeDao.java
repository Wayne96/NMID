/**
 * 
 */
package cqupt.nmid.home.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cqupt.nmid.home.model.ResumeModel;

/**
 * @author MaRong
 * @date 2016年5月17日 下午4:55:25
 * @description 
 */

public interface IResumeDao {
    
    public List<ResumeModel> getResumeById( int userId);
    
    public int getUserIdByName( String name);
    
    public int addResume( List<ResumeModel> list);
    
    public int updateResume( ResumeModel resume);
    
    public int deleteResume(int resumeId, int userId);
}

/**
 * 
 */
package cqupt.nmid.home.dao.impl.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cqupt.nmid.home.dao.IResumeDao;
import cqupt.nmid.home.model.ResumeModel;

/**
 * @author MaRong
 * @date 2016年5月18日 上午10:51:13
 * @description 
 */
@Repository("resumeModel")
public interface ResumeMapper extends IResumeDao{
    @Override
    public List<ResumeModel> getResumeById(@Param("userId") int userId);
    @Override
    public int addResume(@Param("list") List<ResumeModel> list);
    @Override
    public int getUserIdByName(@Param("name") String name);
    @Override 
    public int updateResume( ResumeModel resume);
    @Override
    public int deleteResume(@Param("resumeId") int resumeId,@Param("userId") int userId);
}

package cqupt.nmid.home.dao.impl.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cqupt.nmid.home.dao.IWorkDao;
import cqupt.nmid.home.model.WorkModel;

public interface WorkMapper extends IWorkDao{
    @Override
    public List<WorkModel> getPassedWorkList(@Param("size") int size,@Param("offset") int offset,@Param("sort_by")String sortBy,@Param("order")String order);
    
    @Override
    public List<WorkModel> getUnPassWorkList(@Param("size") int size,@Param("offset") int offset,@Param("sort_by")String sortBy,@Param("order")String order);
    
    @Override
    public List<WorkModel> getUserWork(@Param("user_id") int userId,@Param("size") int size,@Param("offset") int offset,@Param("sort_by")String sortBy,@Param("order")String order);
   
    @Override
    public List<WorkModel> getHotWorksByUser(@Param("id") int id,@Param("size") int size);
    
    @Override
    public int insertWorkAuthors(@Param("work_id")int workId,@Param("authors") List<Integer> authors);
    
    @Override
    public int deleteWorkAuthors(@Param("work_id")int workId,@Param("authors") List<Integer> authors);
}

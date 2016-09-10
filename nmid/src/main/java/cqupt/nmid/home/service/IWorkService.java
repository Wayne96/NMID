package cqupt.nmid.home.service;

import java.util.List;

import cqupt.nmid.home.model.WorkModel;
import cqupt.nmid.home.model.json.ResponseJson;

public interface IWorkService {
    /**
     * 获得作品列表
     * @param page 页数
     * @param pageSize 每页个数
     * @param sortBy 排序依据
     * @param order 排序方式
     * @return
     */
    public ResponseJson getPassedWorks(int page,int pageSize,String sortBy,String order);
    
    public ResponseJson getUnPasstWorks(int page,int pageSize,String sortBy,String order);
    
    public ResponseJson getUserWork(int userId,int page,int pageSize,String sortBy,String order);
    /**
     * 获得作品详情 
     * @return
     */
    public ResponseJson getWork(int id);
    /**
     * 得到用户推荐作品
     */
    public ResponseJson getUserHotWorks(int id,int size);
    /**
     * 更新作品信息
     */
    public ResponseJson updateWork(int id, WorkModel work);
    /**
     * 删除作品
     * @param id
     * @return
     */
    public ResponseJson deleteWork(int id);
    /**
     * 插入作品
     * @param work
     * @return
     */
    public ResponseJson insertWork(WorkModel work);
    
    public ResponseJson addWorkAuthors(int id,List<Integer> authors);
    
    public ResponseJson deleteWorkAuthors(int workId,List<Integer> authors);
}

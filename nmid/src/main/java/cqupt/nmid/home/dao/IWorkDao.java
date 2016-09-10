package cqupt.nmid.home.dao;

import java.util.List;

import cqupt.nmid.home.model.WorkModel;
import cqupt.nmid.home.model.json.UserBaseModel;

public interface IWorkDao {
    /**
     * 获得已通过作品列表
     * @param size 大小
     * @param offset 偏移量
     * @param sortBy 排序依据
     * @param order  排序规则
     * @return
     */
    public List<WorkModel> getPassedWorkList(int size,int offset,String sortBy,String order);
    
    /**
     * 获得未通过作品列表
     * @return
     */
    public List<WorkModel> getUnPassWorkList(int size,int offset,String sortBy,String order);
    /**
     * 获取指定用户项目
     * @param userId 用户ID
     * @return
     */
    public List<WorkModel> getUserWork(int userId, int size,int offset,String sortBy,String order);
    /**
     * 获得作品作者基本信息
     * @param id
     * @return
     */
    public List<UserBaseModel> getWorkAuthor(int id);
    /**
     * 获得已通过作品数量
     */
    public int getPassedWorkCount();
    /**
     * 获得未审核作品数量
     */
    public int getUnPassWorkCount();
    /**
     * 获得指定用户作品数量
     * @param userId 用户ID
     */
    public int getWorkCountByUser(int userId);
    /**
     * 获得作品
     * @param id
     */
    public WorkModel getWork(int id);
    /**
     * 获得用户推荐作品
     * @param id
     * @param size 熟练
     * @return
     */
    public List<WorkModel> getHotWorksByUser(int id,int size);
    /**
     * 增加作品访问量
     * @param id
     */
    public void increaseWorkPv(int id);
    /**
     * 更新作品
     * @param work
     */
    public void updateWork(WorkModel work);
    
    /**
     * 删除作品
     * @param id
     * @return
     */
    public int deleteWork(int id);
    /**
     * 新建作品
     * @param work
     * @return 返回作品id
     */
    public int insertWork(WorkModel work);
    
    public int insertWorkAuthors(int workId,List<Integer> authors);
    
    public int deleteWorkAuthors(int workId,List<Integer> authors);
}

/**
 * 
 */
package cqupt.nmid.home.dao.impl.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cqupt.nmid.home.dao.IHistoryDao;
import cqupt.nmid.home.model.HistoryModel;

/**
 * @author MaRong
 *
 */
@Repository("historyMapper")
public interface HistoryMapper extends IHistoryDao{
    @Override
    public int addHistory(HistoryModel model);
    @Override
    public List<HistoryModel> getHistoryByUser(@Param("id") int uid);
}

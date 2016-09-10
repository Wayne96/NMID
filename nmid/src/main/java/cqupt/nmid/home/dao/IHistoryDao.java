/**
 * 
 */
package cqupt.nmid.home.dao;

import java.util.List;

import cqupt.nmid.home.model.HistoryModel;

/**
 * @author MaRong
 *
 */
public interface IHistoryDao {
    
    public int addHistory(HistoryModel model);
    
    public List<HistoryModel> getHistoryByUser(int uid);
}

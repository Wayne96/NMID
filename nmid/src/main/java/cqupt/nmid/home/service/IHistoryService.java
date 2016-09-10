/**
 * 
 */
package cqupt.nmid.home.service;

import javax.servlet.http.HttpServletRequest;

import cqupt.nmid.home.model.json.ResponseJson;

/**
 * @author MaRong
 *
 */
public interface IHistoryService {
    public ResponseJson addHistory (int uid,HttpServletRequest request);
    
    public ResponseJson getHistoryByUser(int uid);
}

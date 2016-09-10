/**
 * 
 */
package cqupt.nmid.home.dao;

import java.util.List;

import cqupt.nmid.home.model.FileModel;

/**
 * @author MaRong
 * @date 2016年5月12日 下午1:26:50
 * @description 
 */
public interface IFileDao {
    
    public int uploadCommonFile(List<FileModel> fileList);
    
    public int uploadCutFile(FileModel file);
}

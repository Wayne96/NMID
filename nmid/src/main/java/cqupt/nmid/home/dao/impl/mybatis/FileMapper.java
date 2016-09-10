/**
 * 
 */
package cqupt.nmid.home.dao.impl.mybatis;

import java.util.List;

import cqupt.nmid.home.dao.IFileDao;
import cqupt.nmid.home.model.FileModel;

/**
 * @author MaRong
 * @date 2016年5月12日 下午1:27:59
 * @description 
 */
public interface FileMapper extends IFileDao{
    @Override
    public int uploadCommonFile(List<FileModel> fileList);
    
    @Override
    public int uploadCutFile(FileModel file);
}

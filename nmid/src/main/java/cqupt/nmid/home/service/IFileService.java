/**
 * 
 */
package cqupt.nmid.home.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import cqupt.nmid.home.model.json.ResponseJson;

/**
 * @author MaRong
 *
 */
public interface IFileService {
    /*
     * @description 批量上传图片
     * 
    */
    public ResponseJson uploadCommonFile(List<MultipartFile> fileList,HttpServletRequest request) throws IllegalStateException, IOException;
    
    /*
     * @description 上传需要裁剪的图片，参数分别为x,y坐标和宽度高度
     * 
    */
    
    public ResponseJson uploadCutFile(File file,int x,int y,int width,int height);
    
}

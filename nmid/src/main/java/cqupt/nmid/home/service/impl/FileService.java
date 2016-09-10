/**
 * 
 */
package cqupt.nmid.home.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cqupt.nmid.home.constant.StatusCodeConstant;
import cqupt.nmid.home.dao.IFileDao;
import cqupt.nmid.home.model.FileModel;
import cqupt.nmid.home.model.json.ResponseJson;
import cqupt.nmid.home.service.IFileService;
import cqupt.nmid.home.util.ResponseHandelUtil;
import cqupt.nmid.home.util.TimeUtil;

/**
 * @author MaRong
 * 
 */

@Service("fileService")
public class FileService implements IFileService {
    @Autowired
    private IFileDao fileDao;

    @Override
    public ResponseJson uploadCommonFile(List<MultipartFile> fileList,
	    HttpServletRequest request) throws IllegalStateException,
	    IOException {
	String location = request.getServletContext().getInitParameter(
		"fileLocation");
	List<FileModel> fileModelList = new LinkedList<FileModel>();
	for (int i = 0; i < fileList.size(); i++) {
	    MultipartFile file = fileList.get(i);
	    String type = validate(file.getOriginalFilename());
	    if (!file.isEmpty() && type != null) {
		String fileName = System.currentTimeMillis()
			+ request.getLocalAddr() + "." + type;
		File localFile = new File(location, fileName);
		file.transferTo(localFile);

		FileModel fileModel = new FileModel();
		fileModel.setType(type);
		fileModel.setUpload(fileName);
		if (type.equals("apk")) {
		    fileModel.setSize((file.getSize() >> 20) + "MB");
		}
		fileModelList.add(fileModel);

	    }
	}

	int result = fileDao.uploadCommonFile(fileModelList);
	ResponseJson response = ResponseHandelUtil.handleIntCondition(
		fileList.size(), result,
		StatusCodeConstant.INTERNAL_SERVER_ERROR);
	if(response.getCode() == StatusCodeConstant.OK.getCode()) {
	    response.setBody(fileModelList);
	}

	return response;
    }

    @Override
    public ResponseJson uploadCutFile(File file, int x, int y, int width,
	    int height) {
	// TODO Auto-generated method stub
	return null;
    }

    private String validate(String fileName) {
	String type = fileName.substring(fileName.lastIndexOf(".") + 1);
	if (type.equals("jpg") || type.equals("JPG") || type.equals("png")
		|| type.equals("PNG") || type.equals("gif")
		|| type.equals("GIF") || type.equals("apk")) {
	    return type;
	} else {
	    return null;
	}

    }

}

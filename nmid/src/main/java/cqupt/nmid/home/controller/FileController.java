/**
 * 
 */
package cqupt.nmid.home.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cqupt.nmid.home.model.json.ResponseJson;
import cqupt.nmid.home.service.IFileService;

/**
 * @author MaRong
 *
 */

@Controller()
@RequestMapping(value="/file")
public class FileController {
    
    @Autowired
    private IFileService fileService;
    
    @RequestMapping(value="/common",method=RequestMethod.POST)
    @ResponseBody
    public ResponseJson uploadCommonFile(MultipartHttpServletRequest request) throws IllegalStateException, IOException {
	List<MultipartFile> fileList = request.getFiles("files");
	return fileService.uploadCommonFile(fileList,request);
	
    }
    

}

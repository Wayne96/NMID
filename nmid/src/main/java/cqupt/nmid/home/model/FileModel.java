/**
 * 
 */
package cqupt.nmid.home.model;

/**
 * @author MaRong
 * @date 2016年5月4日 下午3:55:48
 * @description 
 */
public class FileModel {
    public Integer id;
    public String upload;
    public String type;
    public String size;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUpload() {
        return upload;
    }
    public void setUpload(String upload) {
        this.upload = upload;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }
    
    
}

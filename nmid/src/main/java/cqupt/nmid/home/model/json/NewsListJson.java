/**
 * 
 */
package cqupt.nmid.home.model.json;

import java.util.List;

import cqupt.nmid.home.model.NewsModel;

/**
 * @author MaRong
 * @date 2016年5月19日 下午4:37:47
 * @description 
 */
public class NewsListJson {
    private int num;
    private int page;
    private List<NewsModel> list;
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public List<NewsModel> getList() {
        return list;
    }
    public void setList(List<NewsModel> list) {
        this.list = list;
    }
    
}

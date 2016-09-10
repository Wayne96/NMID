package cqupt.nmid.home.model.json;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)
public class PageListJson<T> {
    private int num;
    private int page;
    private List<T> list;
    public PageListJson(int num,int page) {
        this.num=num;
        this.page=page;
    }
    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public List<T> getList() {
        return list;
    }
    public void setList(List<T> list) {
        this.list = list;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    @Override
    public String toString() {
        return "BlogListJson [num=" + num + ", page=" + page + ", list=" + getList()
                + "]";
    }
    
}

package cqupt.nmid.home.model.json;

import java.util.List;

import cqupt.nmid.home.model.WorkModel;

public class WorkListModel {
    private int id;
    private String logo;
    private String name;
    private List<UserBaseModel> authors;
    public WorkListModel() { }
    public WorkListModel(WorkModel work) {
        this.id=work.getId();
        this.logo=work.getLogo();
        this.name=work.getName();
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLogo() {
        return logo;
    }
    public void setLogo(String logo) {
        this.logo = logo;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public List<UserBaseModel> getAuthors() {
        return authors;
    }
    public void setAuthors(List<UserBaseModel> authors) {
        this.authors = authors;
    }
    
    @Override
    public String toString() {
        return "WorkListModel [id=" + id + ", logo=" + logo + ", name=" + name
                + ", authors=" + authors + "]";
    }
    
    public static WorkListModel valueOf(WorkModel work,List<UserBaseModel> users){
        WorkListModel wl=new WorkListModel(work);
        wl.setAuthors(users);
        return wl;
    }

}

package cqupt.nmid.home.service.impl;

import static cqupt.nmid.home.constant.StatusCodeConstant.CREATED;
import static cqupt.nmid.home.constant.StatusCodeConstant.GONE;
import static cqupt.nmid.home.constant.StatusCodeConstant.OK;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cqupt.nmid.home.dao.IWorkDao;
import cqupt.nmid.home.exception.RequestParamException;
import cqupt.nmid.home.model.WorkModel;
import cqupt.nmid.home.model.json.PageListJson;
import cqupt.nmid.home.model.json.ResponseFactory;
import cqupt.nmid.home.model.json.ResponseJson;
import cqupt.nmid.home.model.json.ResponseMapJson;
import cqupt.nmid.home.model.json.UserBaseModel;
import cqupt.nmid.home.model.json.WorkListModel;
import cqupt.nmid.home.service.IWorkService;
@Service("workSerivce")
public class WorkService implements IWorkService{
    @Autowired
    @Qualifier("workMapper")
    private IWorkDao workDao;
    
    @Autowired
    @Qualifier("repsonseFactory")
    private ResponseFactory factory;
    @Override
    public ResponseJson getPassedWorks(int page, int pageSize, String sortBy,String order) {
        page=page<=0?1:page;
        List<WorkModel> works=workDao.getPassedWorkList(pageSize, (page-1)*pageSize, sortBy, order);
        int num=workDao.getPassedWorkCount();
        PageListJson<WorkListModel> body=new PageListJson<>(num,page);
        body.setList(createWorkList(works));
        ResponseJson json=new ResponseJson(OK);
        json.setBody(body);
        return json;
    }
    
    @Override
    public ResponseJson getUnPasstWorks(int page, int pageSize, String sortBy,
            String order) {
        page=page<=0?1:page;
        List<WorkModel> works=workDao.getUnPassWorkList(pageSize, (page-1)*pageSize, sortBy, order);
        int num=workDao.getUnPassWorkCount();
        PageListJson<WorkListModel> body=new PageListJson<>(num,page);
        body.setList(createWorkList(works));
        ResponseJson json=new ResponseJson(OK);
        json.setBody(body);
        return json;
    }
    @Override
    public ResponseJson getUserWork(int userId, int page, int pageSize,String sortBy, String order) {
        page=page<=0?1:page;
        List<WorkModel> works=workDao.getUserWork(userId,pageSize, (page-1)*pageSize, sortBy, order);
        int num=workDao.getWorkCountByUser(userId);
        PageListJson<WorkListModel> body=new PageListJson<>(num,page);
        body.setList(createWorkList(works));
        ResponseJson json=new ResponseJson(OK);
        json.setBody(body);
        return json;
    }
    @Override
    public ResponseJson getWork(int id) {
        WorkModel work=workDao.getWork(id);
        List<UserBaseModel> ul=workDao.getWorkAuthor(id);
        workDao.increaseWorkPv(id);
        ResponseMapJson mJson=new ResponseMapJson(OK);
        mJson.put("work", work);
        mJson.put("authors", ul);
        return mJson;
    }
    
    @Override
    public ResponseJson getUserHotWorks(int id, int size) {
        List<WorkModel> works=workDao.getHotWorksByUser(id, size);
        List<WorkListModel> list=new ArrayList<>(); 
        for(WorkModel work:works){
            List<UserBaseModel> ul=workDao.getWorkAuthor(work.getId());
            list.add(WorkListModel.valueOf(work, ul));
        }
        ResponseJson json=new ResponseJson(OK);
        json.setBody(list);
        return json;
    }
    
    @Override
    public ResponseJson updateWork(int id, WorkModel work) {
        work.setId(id);
        workDao.updateWork(work);
        ResponseJson json=new ResponseJson(CREATED);
        return json;
    }
    
    @Override
    public ResponseJson deleteWork(int id) {
        int result=workDao.deleteWork(id);
        if(result==0) throw new RequestParamException();
        return factory.getResponseJsonInstance(GONE);
    }
    @Override
    public ResponseJson insertWork(WorkModel work) {
        workDao.insertWork(work);
        int id=work.getId();
        ResponseMapJson json=factory.getResponseMapJsonInstance(CREATED);
        json.put("url", "/works/"+id);
        return json;
    }
    
    @Override
    public ResponseJson addWorkAuthors(int id, List<Integer> authors) {
        
        workDao.insertWorkAuthors(id, authors);
        return factory.getResponseMapJsonInstance(CREATED);
    }
    
    @Override
    public ResponseJson deleteWorkAuthors(int workId, List<Integer> authors) {
        workDao.deleteWorkAuthors(workId, authors);
        return factory.getResponseMapJsonInstance(GONE);
    }
    
    //===================private method==================================
    
    private List<WorkListModel> createWorkList(List<WorkModel> works){
        List<WorkListModel> list=new ArrayList<>();
        for(WorkModel work:works){
            List<UserBaseModel> ul=workDao.getWorkAuthor(work.getId());
            list.add(WorkListModel.valueOf(work, ul));
        }
        return list;
    }
    
}

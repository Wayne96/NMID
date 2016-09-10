package cqupt.nmid.home.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cqupt.nmid.home.annotation.AdminPermission;
import cqupt.nmid.home.exception.RequestParamException;
import cqupt.nmid.home.exception.UnauthorizedExecption;
import cqupt.nmid.home.model.WorkModel;
import cqupt.nmid.home.model.json.ResponseJson;
import cqupt.nmid.home.service.IWorkService;

@Controller
@RequestMapping("/works")
public class WorkController {
    @Autowired
    @Qualifier("workSerivce") 
    private IWorkService workSerivce;
    
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody ResponseJson getpassedWorkList(@RequestParam(value="page",defaultValue="1",required=false) int page,@RequestParam(value="page_size",defaultValue="16",required=false) int pageSize,@RequestParam(value="sort_by",defaultValue="id",required=false) String sortBy,@RequestParam(value="order",defaultValue="desc",required=false) String order){
        return workSerivce.getPassedWorks(page, pageSize, sortBy, order);
    }
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody ResponseJson insertWork(@RequestBody WorkModel work){
        return workSerivce.insertWork(work);
    }
    @RequestMapping(value="/unpass",method = RequestMethod.GET)
    public @ResponseBody ResponseJson getUnpPassWorkList(@RequestParam(value="page",defaultValue="1",required=false) int page,@RequestParam(value="page_size",defaultValue="16",required=false) int pageSize,@RequestParam(value="sort_by",defaultValue="id",required=false) String sortBy,@RequestParam(value="order",defaultValue="desc",required=false) String order){
        return workSerivce.getUnPasstWorks(page, pageSize, sortBy, order);
    }
    
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public @ResponseBody ResponseJson getWork(@PathVariable(value="id") int id){
        return workSerivce.getWork(id);
    }
    @RequestMapping(value="/{id}",method = RequestMethod.PUT)
    public @ResponseBody ResponseJson updateWork(@PathVariable(value="id") int id,@RequestBody WorkModel work){
        if(work.getIsPass()!=null) throw new UnauthorizedExecption();
        return workSerivce.updateWork(id, work);
    }
    @RequestMapping(value="/{id}/check",method = RequestMethod.PUT)
    public @ResponseBody ResponseJson checkeWork(@PathVariable(value="id") int id,@RequestBody WorkModel work){
        return workSerivce.updateWork(id, work);
    }
    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public @ResponseBody ResponseJson deleteWork(@PathVariable(value="id") int id){
        return workSerivce.deleteWork(id);
    }
    
    @RequestMapping(value="/{id}/authors",method = RequestMethod.POST)
    public @ResponseBody ResponseJson addWorkAuthors(@PathVariable(value="id") int id,@RequestBody List<Integer> authors){
        if(authors==null||authors.size()==0) throw new RequestParamException();
        return workSerivce.addWorkAuthors(id, authors);
    }
    
    @RequestMapping(value="/{id}/authors",method = RequestMethod.DELETE)
    public @ResponseBody ResponseJson deleteWorkAuthors(@PathVariable(value="id") int id,@RequestBody List<Integer> authors){
        if(authors==null||authors.size()==0) throw new RequestParamException();
        return workSerivce.deleteWorkAuthors(id, authors);
    }
}

package cqupt.nmid.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cqupt.nmid.home.model.json.ResponseJson;
import cqupt.nmid.home.service.ITagService;

@Controller
@RequestMapping("/tags")
public class TagController {
    
    @Autowired
    @Qualifier("tagSerivce") 
    private ITagService tagSerivce;
    
    @RequestMapping(value="/hot",method = RequestMethod.GET)
    public @ResponseBody ResponseJson getFrequentlyTags(@RequestParam(value="size",defaultValue="10",required=false) int size){
        return tagSerivce.getFrequentlyTags(size);
    }
    @RequestMapping(value="/{id}/blogs",method = RequestMethod.GET)
    public @ResponseBody ResponseJson getBlogsByTag(@PathVariable(value="id") int tagId,@RequestParam(value="page",defaultValue="1",required=false) int page,@RequestParam(value="page_size",defaultValue="10",required=false) int pageSize,@RequestParam(value="sort_by",defaultValue="time",required=false) String sortBy,@RequestParam(value="order",defaultValue="DESC",required=false) String order){
        return tagSerivce.getBlogListByTag(tagId, page, pageSize, sortBy, order);
    }
}

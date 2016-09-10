/**
 * 
 */
package cqupt.nmid.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cqupt.nmid.home.model.BlogModel;
import cqupt.nmid.home.model.json.ResponseJson;
import cqupt.nmid.home.service.IBlogService;

/**
 * 
 * @author MagicWolf
 *  
 */
@Controller
@RequestMapping("/blogs")
public class BlogController {
    
    @Autowired
    @Qualifier("blogSerivce") 
    private IBlogService blogSerivce;
    
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody ResponseJson getBlogList(@RequestParam(value="page",defaultValue="1",required=false) int page,@RequestParam(value="page_size",defaultValue="10",required=false) int pageSize,@RequestParam(value="sort_by",defaultValue="time",required=false) String sortBy,@RequestParam(value="order",defaultValue="desc",required=false) String order){
        return blogSerivce.getBlogList(page, pageSize,sortBy, order);
    }
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody ResponseJson insertBlog(@RequestBody BlogModel blog){
        return blogSerivce.insertBlog(blog);
    }
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public @ResponseBody ResponseJson getBlog(@PathVariable(value="id") int id){
        return blogSerivce.getBlog(id);
    }
    
    @RequestMapping(value="/{id}",method = RequestMethod.PUT)
    public @ResponseBody ResponseJson updateBlog(@PathVariable(value="id") int id,@RequestBody BlogModel blog){
        return blogSerivce.updateBlog(id, blog);
    }
    
    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public @ResponseBody ResponseJson deleteBlog(@PathVariable(value="id") int id){
        return blogSerivce.deleteBlog(id);
    }
    @RequestMapping(value="/hot",method = RequestMethod.GET)
    public @ResponseBody ResponseJson getTopBlog(@RequestParam(value="size",defaultValue="10",required=false) int size){
        return blogSerivce.getTopBlogs(size);
    }
    @RequestMapping(value="/search",method = RequestMethod.GET)
    public @ResponseBody ResponseJson search(@RequestParam(value="key",defaultValue="",required=false) String key){
        return blogSerivce.search(key);
    }
}

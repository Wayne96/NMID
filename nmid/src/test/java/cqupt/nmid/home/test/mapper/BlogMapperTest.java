package cqupt.nmid.home.test.mapper;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;

import cqupt.nmid.home.dao.IBlogDao;
import cqupt.nmid.home.model.BlogModel;

public class BlogMapperTest {
    private static IBlogDao blogDao;
    @BeforeClass
    public static  void init() {
        ApplicationContext  context = new ClassPathXmlApplicationContext("foreign-mybatis-test.xml"); 
        blogDao = (IBlogDao)context.getBean("blogMapper");
    }
    
    @Before
    public void setUp() throws Exception {
    }

//    @Test
    public void testgetBlogList() {
        List<BlogModel> blogs=blogDao.getBlogList(10,0*10,"created_at", "DESC");
        System.out.println(blogs);
    }
    
//    @Test
    public void testInsertBlog(){
        BlogModel blog=new BlogModel();
        blog.setContent("test");
        blog.setIllustartion("test");
        blog.setPlatform(1);
        blog.setAuthorId(62);
        blog.setProfile("test");
        blog.setTime(1L);
        blog.setTitle("test");
        blogDao.insertBlog(blog);
        int id=blog.getBlogId();
        System.out.println(id);
    }
//    @Test
    public void deleteBlog(){
        int result=blogDao.deleteBlog(102);
        System.out.println(result);
    }
    
    @Test
    public void testUpdateBlog(){
        BlogModel blog=new BlogModel();
        blog.setBlogId(5);
        blog.setContent("update2");
        blog.setProfile("update2");
        int result=blogDao.updateBlog(blog);
        System.out.println(result);
    }

}

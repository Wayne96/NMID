package cqupt.nmid.home.test.mapper;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cqupt.nmid.home.dao.IWorkDao;
import cqupt.nmid.home.model.WorkModel;
import cqupt.nmid.home.model.json.UserBaseModel;

public class WorkMapperTest {
    private static IWorkDao workDao;
    @BeforeClass
    public static  void init() {
        ApplicationContext  context = new ClassPathXmlApplicationContext("foreign-mybatis-test.xml"); 
        workDao = (IWorkDao)context.getBean("workMapper");
    }
    @Before
    public void setUp() throws Exception {
    }

//    @Test
    public void testGetWorkAuthor() {
        List<UserBaseModel> users=workDao.getWorkAuthor(1);
        System.out.println(users);
    }
    @Test
    public void testInsertWork(){
        WorkModel work=new WorkModel();
        work.setFeature("2");
        work.setIllustration("[]");
        work.setInstruction("2");
        work.setLinks("2");
        work.setLogo("2");
        work.setName("2");
        work.setProfile("2");
        work.setSupport("2");
        work.setTime(2L);
        work.setUtility("2");
        work.setVersion("2");
        System.out.println(workDao.insertWork(work));
        System.out.println(work.getId());
    }
//    @Test
    public void testInsertWorkAuthors(){
        int result=workDao.insertWorkAuthors(57, Arrays.asList(61,62));
        Assert.assertEquals(result, 2);
    }
//    @Test
    public void testDeleteWorkAuthors(){
        int result=workDao.deleteWorkAuthors(57, Arrays.asList(61,62));
        Assert.assertEquals(result, 2);
    }
//    @Test
    public void testDeleteWork(){
        int result=workDao.deleteWork(57);
        Assert.assertEquals(result, 1);
    }
    
}

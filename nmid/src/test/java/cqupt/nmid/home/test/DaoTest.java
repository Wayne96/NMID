/**
 * 
 */
package cqupt.nmid.home.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cqupt.nmid.home.constant.StatusConstant;
import cqupt.nmid.home.constant.sql.SortFieldConstant;
import cqupt.nmid.home.dao.INewsDao;
import cqupt.nmid.home.dao.IUserDao;
import cqupt.nmid.home.model.NewsModel;
import cqupt.nmid.home.service.INewsService;
import cqupt.nmid.home.util.TimeUtil;

/**
 * @author MaRong
 * @date 2016年4月26日 下午2:04:22
 * @description 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/nmid*.xml"})
public class DaoTest {
    @Autowired
    private INewsService newsService;
    
    @Autowired
    private IUserDao userDao;
    
    @Test
    public void getNews() {
    }
    
}

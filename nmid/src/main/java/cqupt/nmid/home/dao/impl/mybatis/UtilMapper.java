/**
 * 
 */
package cqupt.nmid.home.dao.impl.mybatis;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cqupt.nmid.home.dao.IUtilDao;

/**
 * @author MaRong
 * 操作数据库的公用工具
 */
@Repository("utilMapper")
public interface UtilMapper extends IUtilDao{
    @Override
    public int addPv(@Param(value = "table") String tableName,@Param(value = "id") int itemId, @Param(value = "pk") String pkName);
}

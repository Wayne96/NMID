/**
 * 
 */
package cqupt.nmid.home.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author MaRong
 * @date 2016年2月23日 上午12:49:32
 * @description
 */

public class TimeUtil {
    public static String getNowTime() {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	return sdf.format(new Date());
    }
    
    public static Long getTimestamp() {
	return System.currentTimeMillis()/1000;
    }
}

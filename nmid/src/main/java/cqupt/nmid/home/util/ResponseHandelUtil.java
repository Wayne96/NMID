/**
 * 
 */
package cqupt.nmid.home.util;

import org.omg.CORBA.Object;

import cqupt.nmid.home.constant.StatusCodeConstant;
import cqupt.nmid.home.model.json.ResponseJson;

/**
 * @author MaRong
 *
 */
public class ResponseHandelUtil {
    public static ResponseJson handleIntCondition(int expectResult,int actualResult,StatusCodeConstant errorCode) {
	if(expectResult == actualResult) {
	    return new ResponseJson(StatusCodeConstant.OK);
	}else {
	    return new ResponseJson(errorCode);
	}
    }
    
    public static ResponseJson handleBooleanCondition(boolean expectResult,boolean actualResult,StatusCodeConstant errorCode) {
	if(expectResult == actualResult) {
	    return new ResponseJson(StatusCodeConstant.OK);
	}else {
	    return new ResponseJson(errorCode);
	}
    }
    
    
}

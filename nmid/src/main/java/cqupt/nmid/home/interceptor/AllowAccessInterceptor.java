/**
 * 
 */
package cqupt.nmid.home.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author MaRong
 * @date 2016年2月22日 下午11:48:12
 * @description 允许跨域访问
 */
public class AllowAccessInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
	    HttpServletResponse response, Object handler) throws Exception {
	response.setHeader("Access-Control-Allow-Origin", "*");
	return super.preHandle(request, response, handler);
    }
    
}

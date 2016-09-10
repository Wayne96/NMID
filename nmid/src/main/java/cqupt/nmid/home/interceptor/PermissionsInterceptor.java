package cqupt.nmid.home.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cqupt.nmid.home.annotation.AdminPermission;
import cqupt.nmid.home.exception.UnauthorizedExecption;
import cqupt.nmid.home.model.BaseUserModel;
import cqupt.nmid.home.util.HttpUtil;
/**
 * 权限拦截器
 * @author MagicWolf
 * 2016年2月1日17:53:52
 * 
 */
public class PermissionsInterceptor extends HandlerInterceptorAdapter{
    
    @Autowired
    @Qualifier("cacheManager")
    private EhCacheCacheManager cacheManger;
    
    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        boolean isPass=true;
        if(method.getAnnotation(AdminPermission.class)!=null){
            isPass=isAdmin(request);
        }
        
        if(!isPass) throw new UnauthorizedExecption();
        
        return isPass;
    }

    private boolean isAdmin(HttpServletRequest request){
        
        Cookie cookie=HttpUtil.getCookieByName(request.getCookies(),"token");
        if(null==cookie) return false;
        String value=cookie.getValue();
        Cache c=cacheManger.getCache("tokenCache");
        BaseUserModel user=c.get(value, BaseUserModel.class);
        if(null==user) return false;
        
        String role=user.getRole();
        return "admin".equals(role);
    }
    
//    private boolean isSelf(HttpServletRequest request){
//        String requestUri = request.getRequestURI();
//        int id=getStudentIdFromURI(requestUri);
//        if(id==-1)return false;
//        HttpSession session=request.getSession();
//        String sessionId=(String)session.getAttribute("id");
//        return sessionId.equals(id);
//    }
    
//    private int getStudentIdFromURI(String uri){
//        String[] uris=uri.split("/");
//        for(int i=0;i<uris.length;i++){
//            String s=uris[i];
//            if(s.equals("students")){
//                if(i==uris.length-1) return -1;
//                return Integer.valueOf(uris[i]);
//            }
//        }
//        return -1;
//    }
}

package cqupt.nmid.home.interceptor;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cqupt.nmid.home.exception.TokenNotExistException;
import cqupt.nmid.home.exception.UnLoginExecption;
import cqupt.nmid.home.model.BaseUserModel;
import cqupt.nmid.home.util.HttpUtil;

public class LoginInterceptor extends HandlerInterceptorAdapter{
    private List<String> excludedUrls;

    private EhCacheCacheManager cacheManger;
    
    public void setExcludedUrls(List<String> excludedUrls) {
        this.excludedUrls = excludedUrls;
    }
    
    public void setCacheManger(EhCacheCacheManager cacheManger) {
        this.cacheManger = cacheManger;
    }
    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        if("GET".equals(request.getMethod())) return true;
        String requestUri = request.getRequestURI();
        for (String url : excludedUrls) { 
            if (requestUri.endsWith(url)) {
                return true;
            }
        }
        Cookie cookie=HttpUtil.getCookieByName(request.getCookies(),"token");
        System.out.println(request.getCookies());
        if(null==cookie) throw new TokenNotExistException();
        String value=cookie.getValue();
        Cache cache=cacheManger.getCache("tokenCache");
        BaseUserModel user=cache.get(value, BaseUserModel.class);
        if(null==user) throw new UnLoginExecption();

        return true;
    }
}

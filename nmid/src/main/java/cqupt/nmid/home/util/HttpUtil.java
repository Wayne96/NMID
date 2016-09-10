package cqupt.nmid.home.util;

import javax.servlet.http.Cookie;

public class HttpUtil {
    
    public static Cookie getCookieByName(Cookie[] cookies,String key){
        if(null==cookies) return null;
        Cookie cookie=null;
        for (Cookie c : cookies) {
            if(c.getName().equals(key)) cookie=c;
        }
        return cookie;
    }
}

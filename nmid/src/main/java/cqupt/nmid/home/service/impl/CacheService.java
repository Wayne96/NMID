/**
 * 
 */
package cqupt.nmid.home.service.impl;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Service;

/**
 * @author MaRong
 */

@Service("cacheService")
public class CacheService {

    @Autowired
    private EhCacheCacheManager cacheManager;

    public Object getCacheObj(String cacheName,String cacheKey) {
	
	return cacheManager.getCache(cacheName).get(cacheKey).get();

    }
    
    public void addToCache(String cacheName,String cacheKey,Object obj) {
	cacheManager.getCache(cacheName).put(cacheKey, obj);
    }
    
    
}

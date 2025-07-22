//package com.spring.boot.config.cache;
//
//import java.net.URL;
//
//import javax.cache.Caching;
//import javax.cache.spi.CachingProvider;
//
//import org.springframework.cache.jcache.JCacheCacheManager;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
//
//@Configuration	
//public class EhcacheConfig {
//
//	  @Bean
//	    public javax.cache.CacheManager ehCacheManager() throws Exception {
//	        CachingProvider provider = Caching.getCachingProvider();
//	        URL url = getClass().getResource("/ehcache.xml");
//	        return provider.getCacheManager(url.toURI(), getClass().getClassLoader());
//	    }
//
//	    @Bean
//	    public org.springframework.cache.CacheManager cacheManager(javax.cache.CacheManager cacheManager) {
//	        return new JCacheCacheManager(cacheManager);
//	    }
//}

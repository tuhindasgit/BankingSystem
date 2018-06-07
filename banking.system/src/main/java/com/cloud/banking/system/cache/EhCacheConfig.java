/**
 * 
 */
package com.cloud.banking.system.cache;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * @author tuhindas 
 *
 */
@EnableCaching
@Configuration
public class EhCacheConfig {

	@Bean
	public CacheManager cacheManager()
	{
		return new EhCacheCacheManager(cacheManagerFactory().getObject());
		
		
	}

	@Bean
	public EhCacheManagerFactoryBean cacheManagerFactory() {
		EhCacheManagerFactoryBean bean= new EhCacheManagerFactoryBean();
		bean.setConfigLocation(new ClassPathResource("ehcache.xml"));
		bean.setShared(true);
		return bean;
	}

//	@Bean
//	private EhCacheManagerFactoryBean cacheManagerFactory() {
//		EhCacheManagerFactoryBean bean= new EhCacheManagerFactoryBean();
//		bean.setConfigLocation(new ClassPathResource("cache.xml"));
//		bean.setShared(true);
//		return bean;
//	}
}

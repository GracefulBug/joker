package com.life.joker.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.concurrent.TimeUnit;

/**
 * @author zhengdeqi
 * @description redis配置类
 * @date 2021/7/5
 */

@Configuration
@EnableCaching
public class CacheConfig {
    @Bean
    @Primary
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        Caffeine caffeine = Caffeine.newBuilder();
        //TTL为10秒
        caffeine.expireAfterWrite(20, TimeUnit.SECONDS);
        cacheManager.setCaffeine(caffeine);
        return cacheManager;
    }

    @Bean
    public CacheManager remoteCacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        Caffeine caffeine = Caffeine.newBuilder();
        //TTL为10秒
        caffeine.expireAfterWrite(20, TimeUnit.SECONDS);
        cacheManager.setCaffeine(caffeine);
        return cacheManager;
    }

    @Bean
    public CacheManager dbCacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        Caffeine caffeine = Caffeine.newBuilder();
        //TTL为10秒
        caffeine.expireAfterWrite(60, TimeUnit.SECONDS);
        cacheManager.setCaffeine(caffeine);
        return cacheManager;
    }

    @Bean
    public CacheManager switchConfigCacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        Caffeine caffeine = Caffeine.newBuilder();
        caffeine.expireAfterWrite(3, TimeUnit.MINUTES);
        cacheManager.setCaffeine(caffeine);
        return cacheManager;
    }
}
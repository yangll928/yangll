package com.yll.cloud.config;

import feign.Retryer;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置feign重试
 * Author: yll
 * date: 2024/4/22
 */
@Configuration
public class FeignConfig {
    @Bean
    public Retryer myRetryer(){

        //默认不重试
        return Retryer.NEVER_RETRY;

        //重试
        //初始间隔时间为100ms,重试间隔时间1s ,最大请求次数3
        //return new Retryer.Default(100,1,3);
    }

    //开启feign日志
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}

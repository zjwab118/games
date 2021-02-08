package com.wm.boot.configuation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.ReactiveStringRedisTemplate;

/**
 * @author wilson
 * @title RedisConfiguation
 * @description Redis配置
 * @date 2021.02.08 19:49
 */
@Configuration
public class RedisConfiguation {

    /***
     * @title redisDb
     * @tescription TODO
     * @version 1.1.0
     * @author wilson
     * @date 2021.02.08 19:51
     * @param factory
     * @return org.springframework.data.redis.core.ReactiveStringRedisTemplate
    */
    @Bean
    ReactiveStringRedisTemplate redisDb(LettuceConnectionFactory factory) {
        factory.setDatabase(2);
        System.out.println(factory.getHostName());
        System.out.println(factory.getPort());
        factory.afterPropertiesSet();
        return new ReactiveStringRedisTemplate(factory);
    }

    /***
     * @title redisDb
     * @tescription TODO
     * @version 1.1.0
     * @author wilson
     * @date 2021.02.08 19:51
     * @param factory
     * @return org.springframework.data.redis.core.ReactiveStringRedisTemplate
     */
    @Bean
    ReactiveStringRedisTemplate redisCache(LettuceConnectionFactory factory) {
        factory.setDatabase(1);
        factory.afterPropertiesSet();
        return new ReactiveStringRedisTemplate(factory);
    }

    @Bean
    LettuceConnectionFactory lettuceConnectionFactory() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setDatabase(0);
        redisStandaloneConfiguration.setHostName("127.0.0.1");
        redisStandaloneConfiguration.setPort(6379);
        // redisStandaloneConfiguration.setPassword(RedisPassword.of(password));

        LettuceClientConfiguration.LettuceClientConfigurationBuilder lettuceClientConfigurationBuilder = LettuceClientConfiguration.builder();
        LettuceConnectionFactory factory = new LettuceConnectionFactory(redisStandaloneConfiguration,
                lettuceClientConfigurationBuilder.build());
        return factory;
    }
}

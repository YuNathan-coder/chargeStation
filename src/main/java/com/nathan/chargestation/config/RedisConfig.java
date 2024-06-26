package com.nathan.chargestation.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nathan.chargestation.vo.UserLoginVo;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author wtx
 * @version 1.0
 * @description： redis 的配置类
 * @date 2021/2/24 11:25 下午
 */
@Configuration
public class RedisConfig {

    @Bean("myRedisTemplate")
    @ConditionalOnMissingBean(name = "myRedisTemplate")
    @SuppressWarnings("all")
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(factory);

        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        jackson2JsonRedisSerializer.setObjectMapper(om);

        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        // key采用String的序列化方式
        template.setKeySerializer(stringRedisSerializer);
        // hash的key也采用String的序列化方式
        template.setHashKeySerializer(stringRedisSerializer);
        // value序列化方式采用jackson
        template.setValueSerializer(jackson2JsonRedisSerializer);
        // hash的value序列化方式采用jackson
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.setEnableTransactionSupport(false);
        template.afterPropertiesSet();

        return template;
    }

    @Bean("userLoginVoRedisTemplate")
    @ConditionalOnMissingBean(name = "userLoginVoRedisTemplate")
    public RedisTemplate<String, UserLoginVo> userLoginVoRedisTemplate (RedisConnectionFactory factory) {

        RedisTemplate<String,UserLoginVo> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);
        Jackson2JsonRedisSerializer<UserLoginVo> serializer =
                new Jackson2JsonRedisSerializer<UserLoginVo>(UserLoginVo.class);
        redisTemplate.setDefaultSerializer(serializer);
        return redisTemplate;


    }
}

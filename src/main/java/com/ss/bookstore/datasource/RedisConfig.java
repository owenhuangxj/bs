package com.ss.bookstore.datasource;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
//    @Autowired
//    private JedisConnectionFactory jedisConnectionFactory;
//
//    /**
//     * @description 自定义的缓存key的生成策略,若想使用这个key  只需要将注解上keyGenerator的值设置为keyGenerator即可</br>
//     * @return 自定义策略生成的key
//     */
//    @Bean
//    public KeyGenerator keyGenerator() {
//        return (Object target,Method method,Object... params)->{
//            StringBuffer sb = new StringBuffer();
//            sb.append(target.getClass().getName());
//            sb.append(method.getName());
//            for (Object obj: params) {
//                sb.append(obj.toString());
//            }
//            return sb.toString();
//        };
//    }
//    //缓存管理器
//    @Bean
//    public RedisCacheManager cacheManager(JedisConnectionFactory jedisConnectionFactory) {
//        return RedisCacheManager.create(jedisConnectionFactory);
//    }
//    @Bean
//    public RedisTemplate<String, Object> redisTemplate(LettuceConnectionFactory lettuceConnectionFactory ) {
//        //设置序列化
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
//        //配置redisTemplate
//        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(lettuceConnectionFactory);
//        RedisSerializer stringSerializer = new StringRedisSerializer();
//        redisTemplate.setKeySerializer(stringSerializer);//key序列化
//        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);//value序列化
//        redisTemplate.setHashKeySerializer(stringSerializer);//Hash key序列化
//        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);//Hash value序列化
//        redisTemplate.afterPropertiesSet();
//        return redisTemplate;
//    }
    @Bean
    public RedisTemplate<String, Object> redisJsonTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
}
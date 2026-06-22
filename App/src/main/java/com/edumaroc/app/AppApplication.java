package com.edumaroc.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@SpringBootApplication
public class AppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

    @Bean
    CommandLineRunner testRedis(RedisTemplate<String, Object> redisTemplate) {
        return args -> {

            System.out.println("WRITING TO REDIS...");

            redisTemplate.opsForValue().set("test", "hello");

            System.out.println("VALUE WRITTEN");

            Object value = redisTemplate.opsForValue().get("test");

            System.out.println("FROM REDIS = " + value);
        };
    }
}

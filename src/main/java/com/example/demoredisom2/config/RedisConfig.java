package com.example.demoredisom2.config;

import com.redis.om.spring.annotations.EnableRedisDocumentRepositories;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRedisDocumentRepositories(basePackages = "com.example.demoredisom2.*")
public class RedisConfig {}

package com.example.demoredisom2.repository;

import com.example.demoredisom2.entity.User;
import com.redis.om.spring.repository.RedisDocumentRepository;

public interface UserRepository extends RedisDocumentRepository<User, String> {
    Iterable<User> search(String text);
}

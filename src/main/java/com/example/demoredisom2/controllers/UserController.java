package com.example.demoredisom2.controllers;

import com.example.demoredisom2.entity.User;
import com.example.demoredisom2.repository.UserRepository;
import com.redis.om.spring.search.stream.EntityStream;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping
    Page<User> getAll(@RequestParam("size") int size, @RequestParam("page") int page) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        return userRepository.findAll(pageable);
    }

    @GetMapping("/by-id")
    User getById(@RequestParam("user-id") String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Element with given ID:" + id + " not found!"));
    }

    @GetMapping("/search/{query}")
    Iterable<User> search(@PathVariable("query") String q) {
        return userRepository.search(q);
    }

}

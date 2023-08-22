package com.example.demoredisom2.controllers;

import com.example.demoredisom2.dto.SearchResponse;
import com.example.demoredisom2.services.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {
    private final SearchService searchService;

    @GetMapping
    public List<SearchResponse> search(@RequestParam String q) {
        return searchService.search(q);
    }
}

package com.example.demoredisom2.services;

import com.example.demoredisom2.dto.MuseumResponse;
import com.example.demoredisom2.repository.ArticleRepository;
import com.example.demoredisom2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class SearchService {
    private static final String USER_RETRIEVE_URI = "/users/id=";
    private static final String ARTICLE_RETRIEVE_URI = "/articles/id=";

    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;

    public List<MuseumResponse> search(String q) {
        var articles = articleRepository.search(q);
        var user = userRepository.search(q);

        var responses = new ArrayList<MuseumResponse>();

        StreamSupport.stream(articles.spliterator(), false)
                .map(a -> new MuseumResponse(a.getTitle(), ARTICLE_RETRIEVE_URI + a.getId()))
                .forEach(responses::add);

        StreamSupport.stream(user.spliterator(), false)
                .map(a -> new MuseumResponse(a.getName(), USER_RETRIEVE_URI + a.getId()))
                .forEach(responses::add);


        return responses;
    }
}

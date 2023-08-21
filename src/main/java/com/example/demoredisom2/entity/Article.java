package com.example.demoredisom2.entity;

import com.redis.om.spring.annotations.Document;
import com.redis.om.spring.annotations.Indexed;
import com.redis.om.spring.annotations.Searchable;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@Document
@RequiredArgsConstructor(staticName = "of")
public class Article {

    @Id
    @Indexed
    private String id;

    @NonNull
    @Searchable
    private String title;

    private String content;
}

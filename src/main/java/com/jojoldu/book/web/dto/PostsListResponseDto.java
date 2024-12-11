package com.jojoldu.book.web.dto;

import com.jojoldu.book.web.domain.posts.Posts;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class PostsListResponseDto {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    public PostsListResponseDto(Posts posts){
        this.id=posts.getId();
        this.title=posts.getTitle();
        this.author=posts.getAuthor();
        this.modifiedDate=posts.getUpdateDate();
    }
}

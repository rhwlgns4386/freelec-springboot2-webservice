package com.jojoldu.book.service.posts;

import com.jojoldu.book.web.domain.posts.Posts;
import com.jojoldu.book.web.domain.posts.PostsRepository;

public class PostsServiceHellper {
    public static Posts findPostsById(PostsRepository postsRepository, Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(
                "해당 게시글을 찾을 수 없습니다. id=" + id));
        return posts;
    }
}

package com.jojoldu.book.service.posts;

import static com.jojoldu.book.service.posts.PostsServiceHellper.*;

import com.jojoldu.book.web.domain.posts.Posts;
import com.jojoldu.book.web.domain.posts.PostsRepository;
import com.jojoldu.book.web.dto.PostsListResponseDto;
import com.jojoldu.book.web.dto.PostsResponseDto;
import com.jojoldu.book.web.dto.PostsSaveRequestDto;
import com.jojoldu.book.web.dto.PostsUpdateRequestDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    public Long save(PostsSaveRequestDto postsSaveRequestDto) {
        return postsRepository.save(postsSaveRequestDto.toEntity()).getId();
    }

    public PostsResponseDto findById(Long id) {
        Posts posts = findPostsById(postsRepository, id);
        return new PostsResponseDto(posts);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream().map(PostsListResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = findPostsById(postsRepository, id);
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return posts.getId();
    }

    @Transactional
    public void delete(Long id) {
        postsRepository.deleteById(id);
    }
}

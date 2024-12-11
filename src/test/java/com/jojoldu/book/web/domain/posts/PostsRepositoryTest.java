package com.jojoldu.book.web.domain.posts;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanUp(){
        postsRepository.deleteAll();;
    }

    @Test
    public void BaseTimeEntity_등록(){
        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(Posts.builder().title("title").content("content").author("author").build());

        List<Posts> all = postsRepository.findAll();
        assertThat(all.get(0).getCreateDate()).isAfterOrEqualTo(now);
        assertThat(all.get(0).getUpdateDate()).isAfterOrEqualTo(now);
    }

    @Test
    public void 게시글저장_불러오기(){
        String title="테스트 게시글";
        String content="테스트 본문";

        postsRepository.save(Posts.builder().title(title).content(content).author("testter@naver.com").build());

        List<Posts> postsList = postsRepository.findAll();
        Posts posts = postsList.get(0);

        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}

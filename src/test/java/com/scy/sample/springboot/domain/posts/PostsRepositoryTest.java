package com.scy.sample.springboot.domain.posts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest // H2 데이터베이스를 자동으로 실행해줌
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach // 테스트 메소드가 실행된 후에 실행되도록 함. 테스트간 데이터 침범을 막기 위함
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void savePostAndInquire() {
        // given
        String title = "test post";
        String content = "test content";

        postsRepository.save( // save : id값이 있다면 update, 없다면 insert 쿼리가 실행됨
                Posts.builder()
                        .title(title)
                        .content(content)
                        .author("cysong98@gmail.com")
                        .build()
        );

        // when
        List<Posts> postsList = postsRepository.findAll(); // findAll : 모든 데이터를 조회

        // then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);

    }
}

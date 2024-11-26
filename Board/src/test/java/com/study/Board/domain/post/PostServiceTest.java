package com.study.Board.domain.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PostServiceTest {

    @Autowired
    PostService postService;

    @Test
    void save(){
        for (int i=0;i<=1000;i++){
            PostRequest params=new PostRequest();
            params.setTitle(i+"번 게시글 제목 테스트");
            params.setContent(i+"번 게시글 내용 테스트");
            params.setWriter("테스터"+i);
            params.setNoticeYn(false);
            postService.savePost(params);
        }
    }
}
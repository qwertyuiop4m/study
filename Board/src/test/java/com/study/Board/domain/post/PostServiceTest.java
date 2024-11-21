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
        PostRequest params=new PostRequest();
        params.setTitle("게시글 제목 테스트");
        params.setContent("게시글 내용 테스트");
        params.setWriter("테스터");
        params.setNoticeYn(false);
        Long id=postService.savePost(params);
        System.out.println("생성된 게시글 ID : "+id);
    }
}
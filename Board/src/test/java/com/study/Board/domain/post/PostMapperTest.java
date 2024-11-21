package com.study.Board.domain.post;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class PostMapperTest {

    @Autowired
    PostMapper postMapper;


    @Test
    @Transactional
    void save() {
        PostRequest params = new PostRequest();
        params.setTitle("1번 게시글 제목");
        params.setContent("1번 게시글 내용");
        params.setWriter("테스터");
        params.setNoticeYn(false);
        postMapper.save(params);

        List<PostResponse> posts = postMapper.findAll();
        System.out.println("전체 게시글 개수는 : " + posts.size() + "개입니다.");
    }

    @Test
    @Transactional
    void findById(){
        PostResponse post= postMapper.findById(1L);
        try {
            String postJson=new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(post);
            System.out.println(postJson);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Transactional
    void update(){
        PostRequest params=new PostRequest();
        params.setId(1L);
        params.setTitle("1번 게시글 제목 수정");
        params.setContent("1번 게시글 내용 수정");
        params.setWriter("철수");
        params.setNoticeYn(true);
        postMapper.update(params);

        PostResponse post= postMapper.findById(1L);
        try {
            String postJson=new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(post);
            System.out.println(postJson);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Transactional
    void delete(){
        System.out.println("삭제 전 게시글 개수 : "+postMapper.findAll().size());
        postMapper.deleteById(1L);
        System.out.println("삭제 후 게시글 개수 : "+postMapper.findAll().size());
    }
}
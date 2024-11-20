package com.study.Board.domain;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Post {
    private Long id; //pk
    private String title; //제목
    private String content; //내용
    private String writer; // 작성자
    private int ViewCnt; // 조회수
    private boolean noticeYn; // 공지글 여부
    private boolean deleteYn; // 삭제 여부
    private LocalDateTime createdDate; // 생성 일시
    private LocalDateTime modifiedDate; // 최종 수정 일시
}

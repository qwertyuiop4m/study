package com.study.Board.domain.post;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequest {
    private Long id;//pk
    private String title;//제목
    private String content;//내용
    private String writer;// 작성자
    private boolean noticeYn;//공지글 여부
}

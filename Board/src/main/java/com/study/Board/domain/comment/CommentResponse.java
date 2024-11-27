package com.study.Board.domain.comment;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponse {

    private Long id; // 댓글 번호 pk
    private Long postId; // 게시글 번호 fk
    private String content; //내용
    private String writer; //작성자
    private Boolean deleteYn; // 삭제 여부
    private LocalDateTime createdDate; // 생성 일시
    private LocalDateTime modifiedDate; //최종 수정 일시
}

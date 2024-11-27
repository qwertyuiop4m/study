package com.study.Board.domain.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentApiController {

    private final CommentService commentService;

    //신규 댓글 생성
    @PostMapping("/posts/{postId}/comments")
    public CommentResponse saveComment(@PathVariable final Long postId, @RequestBody final CommentRequest params){
        Long id= commentService.saveComment(params);
        return commentService.findCommentById(id);
    }
}

package com.study.Board.domain.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //댓글 리스트 조회
    @GetMapping("/posts/{postId}/comments")
    public List<CommentResponse> findAllComment(@PathVariable final Long postId){
        return commentService.findAllComment(postId);
    }

    //댓글 상세정보 조회
    @GetMapping("/posts/{postId}/comments/{id}")
    public CommentResponse findCommentById(@PathVariable final  Long postId,@PathVariable final Long id){
        return commentService.findCommentById(id);
    }

    @PatchMapping("/posts/{postId}/comments/{id}")
    public CommentResponse updateComment(@PathVariable final Long postId,@PathVariable final Long id,@RequestBody final CommentRequest params){
        commentService.updateComment(params);
        return commentService.findCommentById(id);
    }

    @DeleteMapping("/posts/{postId}/comments/{id}")
    public Long deleteComment(@PathVariable final Long postId,@PathVariable final Long id){
        return commentService.deleteComment(id);
    }
}

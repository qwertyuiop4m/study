package com.study.Board.domain.post;

import com.study.Board.common.dto.SearchDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostMapper postMapper;

    /**
     * 게시글 저장
     * @param params - 게시글 정보
     * @return Generated PK
     */
    @Transactional
    public Long savePost(final PostRequest params){
        postMapper.save(params);
        return params.getId();
    }

    /**
     * 게시글 상세정보 조회
     * @param id - PK
     * @return 게시글 상세정보
     */
    @Transactional
    public PostResponse findPostById(final Long id){
        return postMapper.findById(id);
    }

    /**
     * 게시글 수정
     * @param params - 게시글 정보
     * @return PK
     */
    @Transactional
    public Long updatePost(final PostRequest params){
        postMapper.update(params);
        return params.getId();
    }

    /**
     * 게시글 삭제
     * @param id - PK
     * @return PK
     */
    @Transactional
    public Long deletePost(final Long id){
        postMapper.deleteById(id);
        return id;
    }


    /**
     * 게시글 리스트 조회
     * @param params -search conditions
     * @return 게시글 리스트
     */
    @Transactional
    public List<PostResponse> findAllPost(final SearchDto params){
        return postMapper.findAll(params);
    }
}

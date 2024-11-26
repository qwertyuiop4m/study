package com.study.Board.domain.post;

import com.study.Board.common.dto.MessageDto;
import com.study.Board.common.dto.SearchDto;
import com.study.Board.common.paging.PagingResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@Slf4j
public class PostController {

    private final PostService postService;

    @GetMapping("/post/write.do")
    public String openPostWrite(@RequestParam(value = "id",required = false)final Long id, Model model){
       if (id!=null){
           PostResponse post=postService.findPostById(id);
           model.addAttribute("post",post);
       }
        return "post/write";
    }

    @PostMapping("/post/save.do")
    public String savePost(final PostRequest params,Model model){
        postService.savePost(params);
        MessageDto message=new MessageDto("게시글 생성이 완료되었습니다.","/post/list.do", RequestMethod.GET,null);
        return showMessageAndRedirect(message,model);
    }

    @GetMapping("/post/list.do")
    public String openPostList(@ModelAttribute("params") final SearchDto params, Model model) {
        PagingResponse<PostResponse> response = postService.findAllPost(params);
        model.addAttribute("response", response);
        return "post/list";
    }

    @GetMapping("/post/view.do")
    public String openPostView(@RequestParam final Long id,Model model){
        PostResponse post=postService.findPostById(id);
        model.addAttribute("post",post);
        return "post/view";
    }

    @PostMapping("/post/update.do")
    public String updatePost(final PostRequest params,final SearchDto queryParams,Model model){
        postService.updatePost(params);
        MessageDto message=new MessageDto("게시글 수정이 완료되었스니다.","/post/list.do",RequestMethod.GET,queryParamsToMap(queryParams));
        return showMessageAndRedirect(message,model);
    }

    // 게시글 삭제
    @PostMapping("/post/delete.do")
    public String deletePost(@RequestParam final Long id, final SearchDto queryParams, Model model) {
        postService.deletePost(id);
        MessageDto message = new MessageDto("게시글 삭제가 완료되었습니다.", "/post/list.do", RequestMethod.GET, queryParamsToMap(queryParams));
        return showMessageAndRedirect(message, model);
    }

    private String showMessageAndRedirect(final MessageDto params,Model model){
        model.addAttribute("params",params);
        return "common/messageRedirect";
    }

    // 쿼리 스트링 파라미터를 Map에 담아 반환
    private Map<String, Object> queryParamsToMap(final SearchDto queryParams) {
        Map<String, Object> data = new HashMap<>();
        data.put("page", queryParams.getPage());
        data.put("recordSize", queryParams.getRecordSize());
        data.put("pageSize", queryParams.getPageSize());
        data.put("keyword", queryParams.getKeyword());
        data.put("searchType", queryParams.getSearchType());
        return data;
    }
}

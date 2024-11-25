package com.study.Board.domain.post;

import com.study.Board.common.dto.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
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
    public String openPostList(Model model){
        List<PostResponse> posts=postService.findAllPost();
        model.addAttribute("posts", posts);
        return "post/list";
    }

    @GetMapping("/post/view.do")
    public String openPostView(@RequestParam final Long id,Model model){
        PostResponse post=postService.findPostById(id);
        model.addAttribute("post",post);
        return "post/view";
    }

    @PostMapping("/post/update.do")
    public String updatePost(final PostRequest params,Model model){
        postService.updatePost(params);
        MessageDto message=new MessageDto("게시글 수정이 완료되었스니다.","/post/list.do",RequestMethod.GET,null);
        return showMessageAndRedirect(message,model);
    }

    @PostMapping("/post/delete.do")
    public String deletePost(@RequestParam final Long id,Model model){
        postService.deletePost(id);
        MessageDto message=new MessageDto("게시글 삭제가 완료되었습니다.","/post/list.do",RequestMethod.GET,null);
        return showMessageAndRedirect(message,model);
    }

    private String showMessageAndRedirect(final MessageDto params,Model model){
        model.addAttribute("params",params);
        return "common/messageRedirect";
    }
}

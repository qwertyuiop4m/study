package com.study.Board.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/login.do")
    public String OpenLogin(){
        return "member/login";
    }

    @PostMapping("/members")
    @ResponseBody
    public Long saveMember(@RequestBody final MemberRequest params){
        return memberService.saveMember(params);
    }

    @GetMapping("/members/{loginId}")
    @ResponseBody
    public MemberResponse findMemberByLoginId(@PathVariable final String  loginId){
        return memberService.findMemberByLongId(loginId);
    }

    @PatchMapping("/members/{id}")
    @ResponseBody
    public Long updateMember(@PathVariable final Long id,@RequestBody final MemberRequest params){
        return memberService.updateMember(params);
    }

    @DeleteMapping("/members/{id}")
    @ResponseBody
    public Long deleteMemberById(final Long id){
        return memberService.deleteMemberById(id);
    }

    @GetMapping("/member-count")
    @ResponseBody
    public int countMemberByLoginId(@RequestParam final String loginId) {
        return memberService.countMemberByLoginId(loginId);
    }
}

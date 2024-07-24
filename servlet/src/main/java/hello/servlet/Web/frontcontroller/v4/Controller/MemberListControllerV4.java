package hello.servlet.Web.frontcontroller.v4.Controller;


import hello.servlet.Web.frontcontroller.v4.ControllerV4;
import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;

import java.util.List;
import java.util.Map;

public class MemberListControllerV4 implements ControllerV4 {

    private MemberRepository memberRepositroy=MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        List<Member> members = memberRepositroy.findAll();
        model.put("members",members);
        return "members";
    }
}

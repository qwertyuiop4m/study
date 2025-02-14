package hello.servlet.Web.frontcontroller.v4.Controller;

import hello.servlet.Web.frontcontroller.v4.ControllerV4;
import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;

import java.util.Map;

public class MemberSaveControllerV4 implements ControllerV4 {
    private MemberRepository memberRepositroy=MemberRepository.getInstance();


    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        String username= paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member=new Member(username,age);
        memberRepositroy.save(member);

        model.put("member",member);
        return "save-result";
    }
}

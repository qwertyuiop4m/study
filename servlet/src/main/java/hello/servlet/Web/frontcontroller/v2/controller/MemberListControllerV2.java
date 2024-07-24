package hello.servlet.Web.frontcontroller.v2.controller;

import hello.servlet.Web.frontcontroller.Myview;
import hello.servlet.Web.frontcontroller.v2.ControllerV2;
import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class MemberListControllerV2 implements ControllerV2 {

    private MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    public Myview process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Member> members = memberRepository.findAll();
        request.setAttribute("members", members);
        return new Myview("/WEB-INF/views/members.jsp");
    }
}

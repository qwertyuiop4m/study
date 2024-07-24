package hello.servlet.Web.frontcontroller.v2.controller;

import hello.servlet.Web.frontcontroller.Myview;
import hello.servlet.Web.frontcontroller.v2.ControllerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MemberFormControllerV2 implements ControllerV2 {
    @Override
    public Myview process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return new Myview("/WEB-INF/views/new-form.jsp");
    }
}

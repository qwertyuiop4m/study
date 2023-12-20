package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.Order.OrderService;
import hello.core.Order.OrderServiceImpl;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    void configrationTest(){
        ApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService=ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService=ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1= memberService.getMemberRepository();
        MemberRepository memberRepository2=orderService.getMemberRepository();

        System.out.println("memberService-> memberRepository = " + memberRepository1);
        System.out.println("orderService-> memberRepository = " + memberRepository2);
        System.out.println("memberRepository = " + memberRepository);

        Assertions.assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        Assertions.assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
    }

    @Test
    void CofigurationDeep(){
        ApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean=ac.getBean(AppConfig.class);

        System.out.println("bean = " + bean.getClass());
    }
}

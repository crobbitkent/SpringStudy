package springStudy.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springStudy.core.member.Grade;
import springStudy.core.member.Member;
import springStudy.core.member.MemberService;
import springStudy.core.member.MemberServiceImpl;
import springStudy.core.order.Order;
import springStudy.core.order.OrderService;
import springStudy.core.order.OrderServiceImpl;

public class OrderApp
{
	public static void main(String[] args)
	{
		/*AppConfig appConfig = new AppConfig();
		
		int testPrice = 20000;
		
		MemberService memberService = appConfig.memberService();
		OrderService orderService = appConfig.orderService();
		
		Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		memberService.join(member);
		
		Order order = orderService.createOrder(memberId, "itemA", testPrice);
		
		System.out.println("order = " + order);
		System.out.println("cal price = " + order.calculatePrice());*/
		
		// 스프링 모드
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		int testPrice = 20000;
		
		MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
		OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
		
		Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		memberService.join(member);
		
		Order order = orderService.createOrder(memberId, "itemA", testPrice);
		
		System.out.println("order = " + order);
		System.out.println("cal price = " + order.calculatePrice());
	}
}

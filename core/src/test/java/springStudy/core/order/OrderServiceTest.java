package springStudy.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import springStudy.core.AppConfig;
import springStudy.core.member.Grade;
import springStudy.core.member.Member;
import springStudy.core.member.MemberService;
import springStudy.core.member.MemberServiceImpl;

public class OrderServiceTest
{
	MemberService memberService;
	OrderService orderService;
	
	@BeforeEach
	public void beforeEach()
	{
		AppConfig appConfig = new AppConfig();
		memberService = appConfig.memberService();
		orderService = appConfig.orderService();
	}
	
	
	@Test
	void createOrder()
	{
		Long memberId = 1L;
		Member memberA = new Member(memberId, "memberA", Grade.VIP);
		
		memberService.join(memberA);
		
		Order order = orderService.createOrder(memberId, "itemA", 10000);
		Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
	}
}

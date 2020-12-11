package springStudy.core.scan;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springStudy.core.AutoAppConfig;
import springStudy.core.member.MemberRepository;
import springStudy.core.member.MemberService;
import springStudy.core.order.OrderServiceImpl;

public class AutoAppConfigTest
{
	@Test
	void basicScan()
	{
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
		
		MemberService bean = ac.getBean(MemberService.class);
		Assertions.assertThat(bean).isInstanceOf(MemberService.class);
		
		OrderServiceImpl orderService = ac.getBean(OrderServiceImpl.class);
		MemberRepository memberRepository = orderService.getMemberRepository();
		System.out.println("memberRepository = " + memberRepository);
	}
}

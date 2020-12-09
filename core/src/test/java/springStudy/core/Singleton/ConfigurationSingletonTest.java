package springStudy.core.Singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springStudy.core.AppConfig;
import springStudy.core.member.MemberRepository;
import springStudy.core.member.MemberServiceImpl;
import springStudy.core.order.OrderServiceImpl;

public class ConfigurationSingletonTest
{
	@Test
	void configurationTest()
	{
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		
		MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
		OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
		MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);
		
		MemberRepository memberRepository1 = memberService.getMemberRepository();
		MemberRepository memberRepository2 = orderService.getMemberRepository();
		
		Assertions.assertThat(memberRepository1).isEqualTo(memberRepository2);
		Assertions.assertThat(memberRepository1).isEqualTo(memberRepository);
	}
}

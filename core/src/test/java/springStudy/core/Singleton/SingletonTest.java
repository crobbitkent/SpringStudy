package springStudy.core.Singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springStudy.core.AppConfig;
import springStudy.core.member.Member;
import springStudy.core.member.MemberService;

public class SingletonTest
{
	@Test
	@DisplayName("스프링 없는 순수 DI 컨테이너")
	void pureContainer()
	{
		AppConfig appConfig = new AppConfig();
		
		MemberService memberService1 = appConfig.memberService();
		MemberService memberService2 = appConfig.memberService();
		
		
		Assertions.assertThat(memberService1).isNotSameAs(memberService2);
	}
	
	@Test
	@DisplayName("싱글톤 패턴을 적용한 객체 사용")
	void singletonServiceTest()
	{
		SingletonService single1 = SingletonService.getInstance();
		SingletonService single2 = SingletonService.getInstance();
		
		Assertions.assertThat(single1).isEqualTo(single2);
		// isSameAs = 완전 같은지
		// isEqualTo = ... == 오버로딩`
	}
	
	@Test
	@DisplayName("스프링 컨테이너와 싱글톤")
	void springContainer()
	{
		// AppConfig appConfig = new AppConfig();
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		
		MemberService memberService1 = ac.getBean("memberService", MemberService.class);
		MemberService memberService2 = ac.getBean("memberService", MemberService.class);
		
		Assertions.assertThat(memberService1).isSameAs(memberService2);
	}
}

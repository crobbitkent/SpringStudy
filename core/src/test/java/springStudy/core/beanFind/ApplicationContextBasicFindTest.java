package springStudy.core.beanFind;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springStudy.core.AppConfig;
import springStudy.core.member.MemberService;
import springStudy.core.member.MemberServiceImpl;

public class ApplicationContextBasicFindTest
{
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
	
	@Test
	@DisplayName("빈 이름으로 조회")
	void findBeanByName()
	{
		MemberService memberService = ac.getBean("memberService", MemberService.class);
/*		System.out.println("memberService = " + memberService);
		System.out.println("memberService.getClass() = " + memberService.getClass());*/
		Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
		
		
		
	}
	
	@Test
	@DisplayName("타입으로 조회")
	void findBeanByType()
	{
		MemberService memberService = ac.getBean(MemberService.class);
/*		System.out.println("memberService = " + memberService);
		System.out.println("memberService.getClass() = " + memberService.getClass());*/
		Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}
	
	@Test
	@DisplayName("구체 타입으로 조회")
	void findBeanByName2()
	{
		MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
/*		System.out.println("memberService = " + memberService);
		System.out.println("memberService.getClass() = " + memberService.getClass());*/
		Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}
	
	@Test
	@DisplayName("빈 이름으로 조회 X")
	void findBeanByNameX()
	{
		// MemberService memberService = ac.getBean("memberService1", MemberServiceImpl.class);

		org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException.class
				, ()->ac.getBean("memberService1", MemberServiceImpl.class));
	}
}

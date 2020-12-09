package springStudy.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springStudy.core.member.Grade;
import springStudy.core.member.Member;
import springStudy.core.member.MemberService;
import springStudy.core.member.MemberServiceImpl;

public class MemberApp
{
	public static void main(String[] args)
	{
/*		AppConfig appConfig = new AppConfig();
		MemberService memberService = appConfig.memberService();
		
		Member memberA = new Member(1L, "memberA", Grade.VIP);
		memberService.join(memberA);
		
		Member findMember = memberService.findMember(1L);
		
		System.out.println("new member = " + memberA.getName());
		System.out.println("findMember = " + findMember.getName());*/
		
		// 스프링 모드
		
		// AppConfig에 있는 환경설정을 세팅
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
		
		Member memberA = new Member(1L, "memberA", Grade.VIP);
		memberService.join(memberA);
		
		Member findMember = memberService.findMember(1L);
		
		System.out.println("new member = " + memberA.getName());
		System.out.println("findMember = " + findMember.getName());
	}
}

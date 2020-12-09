package springStudy.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springStudy.core.discount.DiscountPolicy;
import springStudy.core.discount.FixDiscountPolicy;
import springStudy.core.discount.RateDiscountPolicy;
import springStudy.core.member.MemberRepository;
import springStudy.core.member.MemberService;
import springStudy.core.member.MemberServiceImpl;
import springStudy.core.member.MemoryMemberRepository;
import springStudy.core.order.OrderService;
import springStudy.core.order.OrderServiceImpl;

// 어플리케이션 전체를 설정하고 구성
/*public class AppConfig
{
	public MemberService memberService()
	{
		return new MemberServiceImpl(memberRepository());
	}
	
	public OrderService orderService()
	{
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}
	
	
	private MemberRepository memberRepository()
	{
		return new MemoryMemberRepository();
	}
	
	private DiscountPolicy discountPolicy()
	{
		return new RateDiscountPolicy();
	}
	
}*/

// 스프링 모드
@Configuration
public class AppConfig
{
	@Bean
	public MemberService memberService()
	{
		return new MemberServiceImpl(memberRepository());
	}
	@Bean
	public OrderService orderService()
	{
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}
	
	@Bean
	public MemberRepository memberRepository()
	{
		return new MemoryMemberRepository();
	}
	@Bean
	public DiscountPolicy discountPolicy()
	{
		return new RateDiscountPolicy();
	}
}
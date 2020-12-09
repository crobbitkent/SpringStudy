package springStudy.core.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springStudy.core.discount.DiscountPolicy;
import springStudy.core.member.Member;
import springStudy.core.member.MemberRepository;

@Component
public class OrderServiceImpl implements OrderService
{

	
	// private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
	// private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
	
	private final MemberRepository memberRepository;
	private final DiscountPolicy discountPolicy;
	
	@Autowired
	public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy)
	{
		this.memberRepository = memberRepository;
		this.discountPolicy = discountPolicy;
	}
	
	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice)
	{
		Member member = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(member, itemPrice);
		
		return new Order(memberId, itemName, itemPrice, discountPrice);
	}
	
	// test
	public MemberRepository getMemberRepository()
	{
		return memberRepository;
	}
}

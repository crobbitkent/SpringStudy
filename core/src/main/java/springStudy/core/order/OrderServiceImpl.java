package springStudy.core.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import springStudy.core.annotation.MainDiscountPolicy;
import springStudy.core.discount.DiscountPolicy;
import springStudy.core.member.Member;
import springStudy.core.member.MemberRepository;

@Component
public class OrderServiceImpl implements OrderService
{

	
	// private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
	// private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
	
	private final MemberRepository memberRepository;
	private final DiscountPolicy discountPolicy; // autowired 필드명으로 중복 조회를 피한다.
	
	@Autowired
	public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy)
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

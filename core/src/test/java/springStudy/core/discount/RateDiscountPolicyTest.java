package springStudy.core.discount;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import springStudy.core.member.Grade;
import springStudy.core.member.Member;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest
{
	RateDiscountPolicy discountPolicy = new RateDiscountPolicy();
	
	@Test
	@DisplayName("VIP는 10프로 할인이 적용되어야 한다.")
	void vipCheck()
	{
		// given
		Member member = new Member(1L, "memberVIP", Grade.VIP);
		
		// when
		int discount = discountPolicy.discount(member, 10000);
		
		// then
		assertThat(discount).isEqualTo(1000);
	}
	
	@Test
	@DisplayName("VIP가 아닐 경우")
	void basicCheck()
	{
		// given
		Member member = new Member(1L, "memberVIP", Grade.BASIC);
		
		// when
		int discount = discountPolicy.discount(member, 10000);
		
		// then
		assertThat(discount).isEqualTo(0);
	}
}
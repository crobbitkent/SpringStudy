package springStudy.core.discount;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springStudy.core.annotation.MainDiscountPolicy;
import springStudy.core.member.Grade;
import springStudy.core.member.Member;

@Component
// @Qualifier("mainDiscountPolicy")
// @Primary
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy
{
	private int discountPercent = 10;
	
	@Override
	public int discount(Member member, int price)
	{
		if(member.getGrade() == Grade.VIP)
		{
			return price * discountPercent / 100;
		}
		else
		{
			return 0;
		}
	}
}

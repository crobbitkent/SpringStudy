package springStudy.core.discount;

import springStudy.core.member.Grade;
import springStudy.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy
{
	private int fixAmount = 1000; // 1000원 할인
	
	@Override
	public int discount(Member member, int price)
	{
		if(member.getGrade() == Grade.VIP)
		{
			return fixAmount;
		}
		else
		{
			return 0;
		}
	}
}

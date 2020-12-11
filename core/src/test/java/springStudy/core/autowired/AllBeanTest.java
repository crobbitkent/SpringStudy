package springStudy.core.autowired;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springStudy.core.AutoAppConfig;
import springStudy.core.discount.DiscountPolicy;
import springStudy.core.member.Grade;
import springStudy.core.member.Member;

import java.util.List;
import java.util.Map;

public class AllBeanTest
{
	@Test
	void findAllBean()
	{
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);
		
		DiscountService discountService = ac.getBean(DiscountService.class);
		Member member = new Member(1L, "userA", Grade.VIP);
		int discountPrice = discountService.discount(member, 20000, "rateDiscountPolicy");
		
		Assertions.assertThat(discountService).isInstanceOf(DiscountService.class);
		Assertions.assertThat(discountPrice).isEqualTo(2000);
	}
	
	static class DiscountService
	{
		private final Map<String, DiscountPolicy> policyMap;
		private final List<DiscountPolicy> policyList;
		
		@Autowired
		public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policyList)
		{
			this.policyMap = policyMap;
			this.policyList = policyList;
			System.out.println("map = " + policyMap);
			System.out.println("list = " + policyList);
		}
		
		public int discount(Member member, int price, String fixDiscountPolicy)
		{
			DiscountPolicy dp = policyMap.get(fixDiscountPolicy);
			return dp.discount(member, price);

		}
	}
}

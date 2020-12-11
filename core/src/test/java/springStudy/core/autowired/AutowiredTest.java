package springStudy.core.autowired;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;
import springStudy.core.member.Member;

import java.util.Optional;

public class AutowiredTest
{
	@Test
	void AutowiredOption()
	{
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
		
	}
	
	static class TestBean
	{
		// false이기 때문에 실행조차 되지 않는다.
		// 주입 대상이 없는 경우 안되고, 있으면 된다.(?)
		@Autowired(required = false)
		public void setNoBean1(Member member)
		{
			System.out.println("noBean1 = " + member);
		}
		
		// null이면 null을 넣기
		@Autowired
		public void setNoBean2(@Nullable Member member)
		{
			System.out.println("noBean2 = " + member);
		}
		
		@Autowired
		public void setNoBean3(Optional<Member> member)
		{
			System.out.println("noBean3 = " + member);
		}
	}
}


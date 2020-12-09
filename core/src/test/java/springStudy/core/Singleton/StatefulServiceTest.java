package springStudy.core.Singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import springStudy.core.AppConfig;

import javax.swing.plaf.nimbus.State;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest
{
	@Test
	void statefulServiceSingleton()
	{
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
		StatefulService state1 = ac.getBean(StatefulService.class);
		StatefulService state2 = ac.getBean(StatefulService.class);
		
		// 쓰레드A = A사용자 10000원 주문
		state1.order("userA", 10000);
		
		// 쓰레드B = B사용자 10000원 주문
		state2.order("userB", 20000);
		
		// 쓰레드A = 사용자A 주문 금액 조회
		int price = state1.getPrice();
	}
	
 
	
	static class TestConfig
	{
		@Bean
		public StatefulService statefulService()
		{
			return new StatefulService();
		}
	}

}
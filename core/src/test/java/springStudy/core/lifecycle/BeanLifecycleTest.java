package springStudy.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifecycleTest
{
	@Test
	public void lifecycleTest()
	{
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(LifecycleConfig.class);
		NetworkClient bean = ac.getBean(NetworkClient.class);
		ac.close();
	}
	
	@Configuration
	static class LifecycleConfig
	{
		// @Bean(initMethod = "init", destroyMethod = "close")
		@Bean
		public NetworkClient networkClient()
		{
			NetworkClient networkClient = new NetworkClient();
			networkClient.setUrl("http://hello-spring.dev");
			return networkClient;
		}
	}
}

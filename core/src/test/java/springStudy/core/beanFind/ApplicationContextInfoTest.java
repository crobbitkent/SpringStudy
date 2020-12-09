package springStudy.core.beanFind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springStudy.core.AppConfig;

public class ApplicationContextInfoTest
{
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
	
	@Test
	@DisplayName("모든 빈 출력하기")
	void findAllBean()
	{
		String[] beanDefinitionNames = ac.getBeanDefinitionNames();
		
		for(String beanDefinitionName : beanDefinitionNames)
		{
			Object bean = ac.getBean(beanDefinitionName);
			System.out.println("name = " + beanDefinitionName + " object = " + bean);
		}
	}
	
	@Test
	@DisplayName("애플리케이션 빈 출력하기")
	void findApplicationBean()
	{
		String[] beanDefinitionNames = ac.getBeanDefinitionNames();
		
		System.out.println("애플리케이션 빈 출력하기");
		
		for(String beanDefinitionName : beanDefinitionNames)
		{
			BeanDefinition beanDef = ac.getBeanDefinition(beanDefinitionName);
			
			if(beanDef.getRole() == BeanDefinition.ROLE_APPLICATION)
			{
				Object bean = ac.getBean(beanDefinitionName);
				System.out.println("name = " + beanDefinitionName + " object = " + bean);
			}
	
		}
	}
}

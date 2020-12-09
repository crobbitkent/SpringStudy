package springStudy.core.beanDefinition;

import net.bytebuddy.description.annotation.AnnotationDescription;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springStudy.core.AppConfig;

public class BeanDefinitionTest
{
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
	
	@Test
	@DisplayName("빈 설정 메타정보 확인")
	void findApplicationBean()
	{
		String[] beanDefinitionNames = ac.getBeanDefinitionNames();
		
		for(String beanDefName : beanDefinitionNames)
		{
			BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefName);
			
			if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION)
			{
				System.out.println("beanDefinitionName = " + beanDefName + " beanDefinition = " + beanDefinition);
				
			}
		}
	}
}

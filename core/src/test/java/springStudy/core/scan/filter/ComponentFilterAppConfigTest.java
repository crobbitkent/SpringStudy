package springStudy.core.scan.filter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

public class ComponentFilterAppConfigTest
{
	@Test
	void filterScan()
	{
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
		BeanA beanA = ac.getBean("beanA", BeanA.class);
		Assertions.assertThat(beanA).isNotNull();
		
		// 제외되어서 컴파일 에러 발생
		// BeanA beanB = ac.getBean("beanB", BeanB.class);
		org.junit.jupiter.api.Assertions.assertThrows(
				NoSuchBeanDefinitionException.class
				, ()->ac.getBean("beanB", BeanB.class)
		);
	}
	
	// 나만의 컴포넌트 스캔 기능
	@Configuration
	@ComponentScan(
				includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = MyIncludeComponent.class),
				excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = MyExcludeComponent.class)
			)
	static class ComponentFilterAppConfig
	{
	
	}
}

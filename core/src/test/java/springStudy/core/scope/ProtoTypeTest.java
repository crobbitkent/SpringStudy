package springStudy.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class ProtoTypeTest
{
	@Test
	void prototypeBeanFind()
	{
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ProtoTypeBean.class);
		System.out.println("find prototypeBean1");
		ProtoTypeBean bean1 = ac.getBean(ProtoTypeBean.class);
		System.out.println("find prototypeBean1");
		ProtoTypeBean bean2 = ac.getBean(ProtoTypeBean.class);
		
		System.out.println("prototypeBean1 = " + bean1);
		System.out.println("prototypeBean2 = " + bean2);
		Assertions.assertThat(bean1).isNotSameAs(bean2);
		
		bean1.destroy();
		bean2.destroy();
		
		ac.close();
	}
	
	@Scope("prototype")
	static class ProtoTypeBean
	{
		@PostConstruct
		public void init()
		{
			System.out.println("ProtoTypeBean.init");
		}
		
		@PreDestroy
		public void destroy()
		{
			System.out.println("ProtoTypeBean.destroy");
		}
	}
	
}

package springStudy.core.scope;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Provider;

public class SingletonWithPrototypeTest
{
	@Test
	void prototypeFind()
	{
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean2.class);
		PrototypeBean2 protoBean2 = ac.getBean(PrototypeBean2.class);
		protoBean2.addCount();
		Assertions.assertThat(protoBean2.getCount()).isEqualTo(1);
		
		PrototypeBean2 protoBean3 = ac.getBean(PrototypeBean2.class);
		protoBean3.addCount();
		Assertions.assertThat(protoBean3.getCount()).isEqualTo(1);
	}
	
	@Test
	void singletonClientUsePrototype()
	{
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean2.class);
		ClientBean clientBean1 = ac.getBean(ClientBean.class);
		ClientBean clientBean2 = ac.getBean(ClientBean.class);
		
		int count1 = clientBean1.logic();
		Assertions.assertThat(count1).isEqualTo(1);
		
		int count2 = clientBean2.logic();
		Assertions.assertThat(count2).isEqualTo(1);
	}
	
	@Scope("singleton")
	static class ClientBean
	{
		private final PrototypeBean2 protoTypeBean2;
		// 생성 시점에 주입된 프로토타입 빈을 계속 가지고 있다.
		
		@Autowired
		// private ObjectProvider<PrototypeBean2> privider;
		private Provider<PrototypeBean2> privider;
		
		@Autowired
		public ClientBean(PrototypeBean2 protoTypeBean2)
		{
			this.protoTypeBean2 = protoTypeBean2;
		}
		
		public int logic()
		{
			// 항상 새로운 객체를 생성해서 리턴
			PrototypeBean2 bean = privider.get();
			bean.addCount();
			int count = bean.getCount();
			return count;
		}
	}
	
	@Scope("prototype")
	static class PrototypeBean2
	{
		private int count = 0;
		
		public void addCount()
		{
			++count;
		}
		
		public int getCount()
		{
			return count;
		}
		
		@PostConstruct
		public void init()
		{
			System.out.println("PrototypeBean.init " + this);
		}
		
		@PreDestroy
		public void destroy()
		{
			System.out.println("PrototypeBean.destroy" + this);
		}
	}
	
}

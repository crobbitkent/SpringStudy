package springStudy.core.scan;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springStudy.core.AutoAppConfig;
import springStudy.core.member.MemberService;

public class AutoAppConfigTest
{
	@Test
	void basicScan()
	{
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
		
		MemberService bean = ac.getBean(MemberService.class);
		Assertions.assertThat(bean).isInstanceOf(MemberService.class);
	}
}

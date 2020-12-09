package springStudy.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan
		(
				// 스캔의 범위를 지정해서 너무 많은 범위를 탐색하지 않도록 최적화 하는 것.
				// 그러나 그냥 이 클래스 파일을 패키지 가장 상단에 두면 그 패키지와 하위를 검색... 이 방법을 주로 사용
			// basePackages = "springStudy.core.member",
				// 기존 예제 코드를 남기기 위해 제외
			excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
		)
public class AutoAppConfig
{

}

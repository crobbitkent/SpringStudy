package springStudy.core.lombok;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.jdbc.metadata.AbstractDataSourcePoolMetadata;

@Getter
@Setter
public class LombokTest
{
	private String name;
	private int age;
	
	public static void main(String[] args)
	{
		LombokTest lombok = new LombokTest();
		lombok.setName("asdf");
		
		String name = lombok.getName();
		System.out.println("name = "+name);
	}
	
	// 롬복을 쓰면 게터세터를 자동으로 만들어줌...
}

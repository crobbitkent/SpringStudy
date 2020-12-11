package springStudy.core.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springStudy.core.common.MyLogger;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController
{
	private final LogDemoService logDemoService;
	// private final ObjectProvider<MyLogger> myLoggerProvider;
	private final MyLogger myLogger;
	
	@RequestMapping("log-demo")
	@ResponseBody
	public String logDemo(HttpServletRequest request)
	{
		// MyLogger myLogger = myLoggerProvider.getObject();
		String requestURL = request.getRequestURL().toString();
		myLogger.setRequestURL(requestURL);
		
		System.out.println("myLogger = " + myLogger.getClass());
		
		myLogger.log("controller test");
		logDemoService.logic("testID");
		
		return "OK";
	}

}

package hyl.com.hy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EzController {
	
	@Autowired
	private Environment env;
	
	@RequestMapping("")
	public String test() {
		return "AWS!" + env.getProperty("PATH") + "||||" + env.getProperty("REDISURL");
	}
}

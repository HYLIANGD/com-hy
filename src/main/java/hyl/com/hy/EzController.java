package hyl.com.hy;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EzController {
	
	@RequestMapping("")
	public String test() {
		return "OK";
	}
}

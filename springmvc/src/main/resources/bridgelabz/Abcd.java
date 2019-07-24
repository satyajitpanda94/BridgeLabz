package bridgelabz;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Abcd {
	@RequestMapping("/show")
public void show() {
	System.out.println("hello");
}
}

package sumeng.home;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sumeng.home.service.TestService;


class HomeApplicationTests {

	@Autowired
	private TestService testService;


	@Test
	String test() {
		System.out.println("going");
		return testService.get();
	}

}

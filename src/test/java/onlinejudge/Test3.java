package onlinejudge;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import onlinejudge.repository.UserRepository;

public class Test3 extends TestBase {
	@Autowired
	UserRepository userRepository;
	@Test
	public void contextLoads() {
		System.out.println("Test3...........");
		System.out.println(userRepository);
	}
}

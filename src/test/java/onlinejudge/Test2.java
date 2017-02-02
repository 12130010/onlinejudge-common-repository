package onlinejudge;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import onlinejudge.repository.UserRepository;
public class Test2 extends TestBase {
	@Autowired
	UserRepository userRepository;
	@Test
	public void contextLoads() {
		System.out.println("Test2...........");
		System.out.println(userRepository);
	}
}

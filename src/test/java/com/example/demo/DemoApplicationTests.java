package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
		int i = 1;
		while (i <= 10) {
			if (i == 5) {
				//i++;
				System.out.println("死循环");
				continue;
			}
			System.out.println(i);
			i++;
		}
	}

}

package cn.wfc.book;

import cn.wfc.book.bean.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class BookApplicationTests {
	@Autowired
	Person person;
	@Autowired
	ApplicationContext ac;

	@Test
	void contextLoads() {
		System.out.println(person);
	}

}

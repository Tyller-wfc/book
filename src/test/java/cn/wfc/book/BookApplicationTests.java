package cn.wfc.book;

import cn.wfc.book.bean.Person;
import cn.wfc.book.bean.User;
import cn.wfc.book.dao.NotebookDao;
import cn.wfc.book.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Map;

@SpringBootTest
class BookApplicationTests {
	@Autowired
	Person person;
	@Autowired
	ApplicationContext ac;
	@Autowired
	UserDao userDao;
	@Autowired
	NotebookDao notebookDao;
	@Test
	void contextLoads() {
		List<Map<String, Object>> notebooksByUserId = notebookDao.findNotebooksByUserId("39295a3d-cc9b-42b4-b206-a2e7fab7e77c");
		System.out.println(notebooksByUserId.size());
	}

}

package cn.wfc.book;

import cn.wfc.book.bean.Person;
import cn.wfc.book.bean.User;
import cn.wfc.book.dao.NotebookDao;
import cn.wfc.book.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.boot.autoconfigure.amqp.RabbitRetryTemplateCustomizer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
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
    @Autowired
    DataSource dataSource;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    void testRabbit() {
        rabbitTemplate.convertAndSend("wfc.direct", "wfc.news", "王依，天天向上");
        System.out.println("发送成功");
    }
    @Test
    void testRabbit2(){
        Object receive = rabbitTemplate.receiveAndConvert("wfc.news");
        System.out.println(receive);
    }


    @Test
    void redisTest() {
        //stringRedisTemplate.opsForValue().set("key1", "val1");
        String val = stringRedisTemplate.opsForValue().get("key1");
        System.out.println(val);
    }

    @Test
    void contextLoads() throws SQLException {
        /*List<Map<String, Object>> notebooksByUserId = notebookDao.findNotebooksByUserId("39295a3d-cc9b-42b4-b206-a2e7fab7e77c");
		System.out.println(notebooksByUserId.size());*/
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

}

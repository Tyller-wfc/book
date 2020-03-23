package cn.wfc.book.config;

import cn.wfc.book.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAppConfig {
    @Bean
    public HelloService helloService(){
        return new HelloService();
    }
}

package cn.wfc.book.config;

import cn.wfc.book.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class MyAppConfig implements WebMvcConfigurer{
    @Bean
    public HelloService helloService(){
        return new HelloService();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
     registry.addViewController("/").setViewName("index");
     registry.addViewController("/index.html").setViewName("index");
     registry.addViewController("/edit.html").setViewName("edit");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).
                addPathPatterns("/**").
                excludePathPatterns("/index.html","/","/login","/**/*.css","/**/*.js");
    }
}

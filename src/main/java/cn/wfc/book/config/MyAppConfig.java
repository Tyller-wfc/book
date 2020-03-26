package cn.wfc.book.config;

import cn.wfc.book.service.HelloService;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class MyAppConfig implements WebMvcConfigurer{
    @Bean
    public HelloService helloService(){
        return new HelloService();
    }

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource dataSource(){
        return new DruidDataSource();
    }

    /**
     * 配置durid监控
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String, String> initParam = new HashMap<>();
        initParam.put("loginUsername", "admin");
        initParam.put("loginPassword", "111111");
        return registrationBean;
    }

    /**
     * 配置druid的监控
     * @return
     */
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new WebStatFilter());
        Map<String, String> initParam = new HashMap<>();
        initParam.put("exclusions", "*.js,*.css,/druid/*");
        registrationBean.setUrlPatterns(Arrays.asList("/*"));
        return registrationBean;
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

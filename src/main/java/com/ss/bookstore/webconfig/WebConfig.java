package com.ss.bookstore.webconfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.*;
@EnableWebMvc//表示该类是做Spring MVC 配置的
@Configuration //表示将该类注册到Spring IoC容器中去
@ComponentScan(value = "com.ss.bookstore.controller")
public class WebConfig implements WebMvcConfigurer {
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/**/login/**");
//    }
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedHeaders("*")//允许所有Header，默认也是允许所有Header
                .allowedMethods("*")//允许所有http方法请求本服务
                .allowedOrigins("*")//允许本服务的所有资源都可以被请求，默认也是所有资源
                .maxAge(600);//配置客户端可以在几秒钟内缓存来自pre-light请求的响应,默认是1800秒，即30分钟
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("resources/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX.concat("classpath:/static/")).setCachePeriod(60 * 60 * 24 * 7);
    }

    //DispatcherServlet配置home页面，也可以在Controller中进行制定home页,如下所示
    /*@GetMapping("/")
    public String login(){
        return "login";
    }*/
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("login");//login指向classpath:/templates/login.html
//        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
//        super.addViewControllers(registry);
//    }
}
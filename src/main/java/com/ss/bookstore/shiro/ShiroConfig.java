package com.ss.bookstore.shiro;
import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // setLoginUrl 如果不设置值，默认会自动寻找Web工程根目录下的"/login.jsp"页面 或 "/login" 映射
        shiroFilterFactoryBean.setLoginUrl("/notLogin");
        // 设置无权限时跳转的 url;
        shiroFilterFactoryBean.setUnauthorizedUrl("/notRole");
        // 设置拦截器,LinkedHashMap内部维持了一个双向链表,可以保持顺序,能够让你取数据时，取出的数据保持进入的顺序
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        //游客，比如开发权限
        filterChainDefinitionMap.put("/guest/**", "anon");
        //用户，需要角色权限 “user”
        filterChainDefinitionMap.put("/user/**", "roles[user]");
        //管理员，需要角色权限 “admin”
        filterChainDefinitionMap.put("/admin/**", "roles[admin]");
        //游客可以访问login，即开放登陆接口，让所有人都可以访问登陆页面
        filterChainDefinitionMap.put("/login", "anon");
        //游客可以访问LoginAction，LoginAction是管理员登陆接口，对应的是URL为/LoginAction的Handler
        filterChainDefinitionMap.put("/LoginAction","anon");

        //其余接口一律拦截,这行代码必须放在所有权限设置的最后，不然会导致所有 url 都被拦截
        filterChainDefinitionMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        System.out.println("**********************************Shiro拦截器工厂类注入成功**********************************");
        return shiroFilterFactoryBean;
    }
    /**
     * 注入 securityManager
     */
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置管理器管理的域即realm.
        securityManager.setRealm(customRealm());
        return securityManager;
    }
    /**
     * 自定义身份认证 realm;
     * 必须写这个类，并加上 @Bean 注解，目的是注入 CustomRealm，
     * 否则会影响 CustomRealm类 中其他类的依赖注入
     */
    @Bean
    public CustomRealm customRealm() {
        return new CustomRealm();
    }

    /**
     * 配置该类后就可以解析页面中 <div>Hello, </div><shiro:principal/>, how are you today?</div>
     * <p shiro:hasRole="user"> hello,user</p>等shiro标签和标签属性，当然页面的<html></html>中还必须引入
     * xmlns:shiro="http://www.pollix.at/thymeleaf/shiro" 命名空间
     */
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }
}
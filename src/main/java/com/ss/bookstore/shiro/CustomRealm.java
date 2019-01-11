package com.ss.bookstore.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ss.bookstore.entity.User;
import com.ss.bookstore.mapper.UserMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;
//@Component
//realm : 领域
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class CustomRealm extends AuthorizingRealm {
    @Autowired
    private UserMapper userMapper;
    /**
     * 获取身份验证信息
     * Shiro中，最终是通过 Realm 来获取应用程序中的用户、角色及权限信息的。
     * 该方法也是用户登录验证
     * @param authenticationToken 用户身份信息 token
     * @return 返回封装了用户信息的 AuthenticationInfo 实例
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("————————身份认证方法————————");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        token.setRememberMe(true);
        System.out.println("is token null : " + token);
        // 从数据库获取对应用户名密码的用户,以此来验证用户
        String password = userMapper.selectOne(new QueryWrapper<User>().eq("user_name",token.getUsername())).getUserPassword();
        /*if (null == password) {
            throw new AccountException("用户名不正确");
        }else if ( !password.equals( new String( token.getPassword() ) ) ) {
            throw new AccountException("密码不正确");
        }*/
        if(null==password || !password.equals(new String(token.getPassword()))) throw new AccountException("用户名或密码不正确");
        //如果登录成功则将用户的信息进行封装存入AuthenticationInfo中去
        return new SimpleAuthenticationInfo( token.getPrincipal(), password, getName() );//getName()是CustomRealm的父类AuthorizingRealm的父类CachingRealm的方法
    }
    /**
     * 获取授权信息
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("————————权限认证————————");
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获得该用户角色
        String role = userMapper.selectOne(new QueryWrapper<User>().select("user_role").eq("user_name",username)).getUserRole();
        Set<String> set = new HashSet<>();
        //需要将 role 封装到 Set 作为 info.setRoles() 的参数
        set.add(role);
        //设置该用户拥有的角色
        info.setRoles(set);
        return info;
    }

}
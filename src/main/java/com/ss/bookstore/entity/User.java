package com.ss.bookstore.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.*;
@TableName("t_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    /**
     * 用户id
     */
    @TableId
    private Long userId;
    /**
     * 用户名,昵称
     */
    private String userName;

    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 积分
     */
    private Integer userCredit;
    /**
     * 账号状态
     */
    private Boolean userIsActive;
    /**
     * 用户电话
     */
    private String userPhone;
    /**
     * 用户email
     */
    private String userEmail;
    /**
     * 用户余额
     */
    private Double userBalance;
    /**
     *用户角色
     */
    private String userRole;
    /**
     * 用户购物车状态
     */
    private Boolean userCartStatus;
    /**
     * 用户注册时间
     */
    private Date userRegisterTime;
    /**
     * 用户最后登录时间
     */
    private Date userLastLoginTime;
    /**
     * 所有的收货地址
     */
    @TableField(exist = false) //exist=false表示该属性不是数据库表字段
    private Set<DeliveryAddress> addresses = new HashSet<>();
    /**
     * 浏览过但是没有买过的书
     */
    @TableField(exist = false)
    private List<Book> visitedBooks = new ArrayList<>();
    /**
     * 买过的书
     */
    @TableField(exist = false)
    private List<Order> orders = new ArrayList<>();
    /**
     * 购物车
     * Map类型，key是Book，value是数量
     */
    @TableField(exist = false)
    private Map<Book, Integer> cart = new HashMap<>();
    @TableField(exist = false)
    private List<Coupon> coupons = new ArrayList<Coupon>();
    public User(Long userId, String userName, String userPassword, String userRole) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userRole = userRole;
    }

    public User(Long userId, String userName, String userPassword, Integer userCredit, Boolean userIsActive, String userPhone, String userEmail, Double userBalance, String userRole, Boolean userCartStatus, Date userRegisterTime, Date userLastLoginTime) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userCredit = userCredit;
        this.userIsActive = userIsActive;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.userBalance = userBalance;
        this.userRole = userRole;
        this.userCartStatus = userCartStatus;
        this.userRegisterTime = userRegisterTime;
        this.userLastLoginTime = userLastLoginTime;
    }
}

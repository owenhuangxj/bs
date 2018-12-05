package com.ss.bookstore.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.*;

@TableName("t_user")
public class User implements Serializable {
    /**
     * 用户id
     */
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
    @TableField(exist = false)
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getUserCredit() {
        return userCredit;
    }

    public void setUserCredit(Integer userCredit) {
        this.userCredit = userCredit;
    }

    public Boolean getUserIsActive() {
        return userIsActive;
    }

    public void setUserIsActive(Boolean userIsActive) {
        this.userIsActive = userIsActive;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Double getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(Double userBalance) {
        this.userBalance = userBalance;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public Boolean getUserCartStatus() {
        return userCartStatus;
    }

    public void setUserCartStatus(Boolean userCartStatus) {
        this.userCartStatus = userCartStatus;
    }

    public Date getUserRegisterTime() {
        return userRegisterTime;
    }

    public void setUserRegisterTime(Date userRegisterTime) {
        this.userRegisterTime = userRegisterTime;
    }

    public Date getUserLastLoginTime() {
        return userLastLoginTime;
    }

    public void setUserLastLoginTime(Date userLastLoginTime) {
        this.userLastLoginTime = userLastLoginTime;
    }

    public Set<DeliveryAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<DeliveryAddress> addresses) {
        this.addresses = addresses;
    }

    public List<Book> getVisitedBooks() {
        return visitedBooks;
    }

    public void setVisitedBooks(List<Book> visitedBooks) {
        this.visitedBooks = visitedBooks;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Map<Book, Integer> getCart() {
        return cart;
    }

    public void setCart(Map<Book, Integer> cart) {
        this.cart = cart;
    }

    public List<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<Coupon> coupons) {
        this.coupons = coupons;
    }

    public User() {
    }

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

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userCredit=" + userCredit +
                ", userIsActive=" + userIsActive +
                ", userPhone='" + userPhone + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userBalance=" + userBalance +
                ", userRole='" + userRole + '\'' +
                ", userCartStatus=" + userCartStatus +
                ", userRegisterTime=" + userRegisterTime +
                ", userLastLoginTime=" + userLastLoginTime +
                ", addresses=" + addresses +
                ", visitedBooks=" + visitedBooks +
                ", orders=" + orders +
                ", cart=" + cart +
                ", coupons=" + coupons +
                '}';
    }
}

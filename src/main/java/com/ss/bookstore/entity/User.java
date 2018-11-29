package com.ss.bookstore.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    private String userPwd;

    /**
     * 积分
     */
    private Integer credit;
    /**
     * 账号状态
     */
    private Boolean active;
    /**
     * 用户电话
     */
    private String cellphone;
    /**
     * 用户email
     */
    private String email;
    /**
     * 所有的收货地址
     */
    private Set<DeliveryAddress> addresses = new HashSet<>();
    /**
     * 浏览过但是没有买过的书
     */
    private List<Book> visited = new ArrayList<>();
    /**
     * 买过的书
     */
    private List<Order> orders = new ArrayList<>();
    /**
     * 购物车
     * Map类型，key是Book，value是数量
     */
    private Map<Book, Integer> cart = new HashMap<>();

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

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<DeliveryAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<DeliveryAddress> addresses) {
        this.addresses = addresses;
    }

    public List<Book> getVisited() {
        return visited;
    }

    public void setVisited(List<Book> visted) {
        this.visited = visted;
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

    public User(Long userId, String userName, Integer credit, Boolean active, String cellphone, String email) {
        this.userId = userId;
        this.userName = userName;
        this.credit = credit;
        this.active = active;
        this.cellphone = cellphone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", credit=" + credit +
                ", active=" + active +
                ", cellphone='" + cellphone + '\'' +
                ", email='" + email + '\'' +
                ", addresses=" + addresses +
                ", visited=" + visited +
                ", orders=" + orders +
                ", cart=" + cart +
                ", coupons=" + coupons +
                '}';
    }
}

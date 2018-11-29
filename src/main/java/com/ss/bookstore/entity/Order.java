package com.ss.bookstore.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Order implements Serializable {
	/**
	 * 订单编号
	 */
	private Long orderId;
	/**
	 * 下单时间
	 */
	private String orderedTime;
	/**
	 * 支付时间
	 */
	private String payTime;
	/**
	 * 支付方式
	 */
	private String payWay;
	/**
	 * 物流方式
	 */
	private String deliveryWay;
	/**
	 * 收货时间
	 */
	private String acceptTime;
	/**
	 * 物流号
	 */
	private String deliveryId;
	/**
	 * 订单总额
	 */
	private BigDecimal amount;
	/**
	 * 订单所包括的书+数量
	 */
	private Map<Book,Integer> books = new HashMap<>();
	/**
	 * 订单状态
	 * 	1.完成
	 * 	2.待支付
	 * 	3.待发货
	 * 	4.送货中（已发货，待收货）
	 * 	5.申请退货，协商中
	 * 	6.退货，未揽活
	 * 	7.退货，已回寄
	 * 	8.退货完成
	 * 	9.待评价
	 * 	10.已取消
	 * 	11.售后：退/换
	 */
	private Integer orderStatus;
	/**
	 * 优惠
	 */
	private Coupon coupon;
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getOrderedTime() {
		return orderedTime;
	}
	public void setOrderedTime(String orderedTime) {
		this.orderedTime = orderedTime;
	}
	public String getPayTime() {
		return payTime;
	}
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
	public String getPayWay() {
		return payWay;
	}
	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}
	public String getDeliveryWay() {
		return deliveryWay;
	}
	public void setDeliveryWay(String deliveryWay) {
		this.deliveryWay = deliveryWay;
	}
	public String getAcceptTime() {
		return acceptTime;
	}
	public void setAcceptTime(String acceptTime) {
		this.acceptTime = acceptTime;
	}
	public String getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(String deliveryId) {
		this.deliveryId = deliveryId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Map<Book, Integer> getBooks() {
		return books;
	}
	public void setBooks(Map<Book, Integer> books) {
		this.books = books;
	}
	public Integer getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Coupon getCoupon() {
		return coupon;
	}
	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}
	
	public Order(){
		
	}
	public Order(String orderedTime, String payTime, String payWay, String deliveryWay, String acceptTime,
			String deliveryId, BigDecimal amount, Map<Book, Integer> books, Integer orderStatus, Coupon coupon) {
		this.orderedTime = orderedTime;
		this.payTime = payTime;
		this.payWay = payWay;
		this.deliveryWay = deliveryWay;
		this.acceptTime = acceptTime;
		this.deliveryId = deliveryId;
		this.amount = amount;
		this.books = books;
		this.orderStatus = orderStatus;
		this.coupon = coupon;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderedTime=" + orderedTime + ", payTime=" + payTime + ", payWay="
				+ payWay + ", deliveryWay=" + deliveryWay + ", acceptTime=" + acceptTime + ", deliveryId=" + deliveryId
				+ ", amount=" + amount + ", books=" + books + ", orderStatus=" + orderStatus + ", coupon=" + coupon
				+ "]";
	}
}

package com.ss.bookstore.entity;

import java.io.Serializable;

/**
 * 收获地址
 * @author Owen
 *
 */
public class DeliveryAddress implements Serializable {
	private Long addressId;
	
	private Long userId;
	/**
	 * 国家
	 */
	private String country;
	/**
	 * 省
	 */
	private String province;
	/**
	 * 市
	 */
	private String city;
	/**
	 * 区/县
	 */
	private String county;
	/**
	 * 详细
	 */
	private String DetailAddress;
	/**
	 * 收货人
	 */
	private String receiver;
	/**
	 * 收获人电话
	 */
	private String phone;
	/**
	 * 默认地址标志
	 */
	private Boolean isDefaultAddress;
	
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getDetailAddress() {
		return DetailAddress;
	}
	public void setDetailAddress(String detailAddress) {
		DetailAddress = detailAddress;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Boolean getIsDefaultAddress() {
		return isDefaultAddress;
	}
	public void setIsDefaultAddress(Boolean isDefaultAddress) {
		this.isDefaultAddress = isDefaultAddress;
	}
	public DeliveryAddress() {
		super();
	}
	public DeliveryAddress(String country, String province, String city, String county, String detailAddress,
			String receiver, String phone, Boolean isDefaultAddress) {
		super();
		this.country = country;
		this.province = province;
		this.city = city;
		this.county = county;
		DetailAddress = detailAddress;
		this.receiver = receiver;
		this.phone = phone;
		this.isDefaultAddress = isDefaultAddress;
	}
	public DeliveryAddress(String country, String detailAddress, Boolean isDefaultAddress) {
		this.country = country;
		DetailAddress = detailAddress;
		this.isDefaultAddress = isDefaultAddress;
	}
	@Override
	public String toString() {
		return "DeliveryAddress [addressId=" + addressId + ", userId=" + userId + ", country=" + country + ", province="
				+ province + ", city=" + city + ", county=" + county + ", DetailAddress=" + DetailAddress
				+ ", receiver=" + receiver + ", phone=" + phone + ", isDefaultAddress=" + isDefaultAddress + "]";
	}
}

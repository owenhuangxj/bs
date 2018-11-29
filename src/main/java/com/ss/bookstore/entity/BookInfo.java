package com.ss.bookstore.entity;

import java.io.Serializable;

public class BookInfo implements Serializable{
	private static final long serialVersionUID = -2759895446625468391L;
	private String bookInfoId;
	private String bookId;
	private String detail;
	public String getBookInfoId() {
		return bookInfoId;
	}
	public void setBookInfoId(String bookInfoId) {
		this.bookInfoId = bookInfoId;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	@Override
	public String toString() {
		return "BookInfo [bookInfoId=" + bookInfoId + ", bookId=" + bookId + ", detail=" + detail + "]";
	}
	public BookInfo(){}
	public BookInfo(String bookId, String detail) {
		this.bookId = bookId;
		this.detail = detail;
	}
}

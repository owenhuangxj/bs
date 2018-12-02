package com.ss.bookstore.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@TableName("t_book")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book implements Serializable{
	private static final long serialVersionUID = 597733879789573558L;
	private Long id;
	private String bookId;
	private String bookName;
	private String bookKind;
	private Integer bookPrice;
	private String bookCoverPic;
	private String bookIntro;
	private Boolean isJoiningActivity;
	private Integer bookStatus;
	private String bookPublisher;
	private String bookPublishDate;
//	private List<Author> bookAuthor;
//	private BookInfo bookInfo;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookKind() {
		return bookKind;
	}
	public void setBookKind(String bookKind) {
		this.bookKind = bookKind;
	}
	public Integer getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(Integer bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getBookCoverPic() {
		return bookCoverPic;
	}
	public void setBookCoverPic(String bookCoverPic) {
		this.bookCoverPic = bookCoverPic;
	}
	public String getBookIntro() {
		return bookIntro;
	}
	public void setBookIntro(String bookIntro) {
		this.bookIntro = bookIntro;
	}
	public Boolean getIsJoiningActivity() {
		return isJoiningActivity;
	}
	public void setIsJoiningActivity(Boolean isJoiningActivity) {
		this.isJoiningActivity = isJoiningActivity;
	}
	public Integer getBookStatus() {
		return bookStatus;
	}
	public void setBookStatus(Integer bookStatus) {
		this.bookStatus = bookStatus;
	}
	public String getBookPublisher() {
		return bookPublisher;
	}
	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}
	public String getBookPublishDate() {
		return bookPublishDate;
	}
	public void setBookPublishDate(String bookPublishDate) {
		this.bookPublishDate = bookPublishDate;
	}
//	public List<Author> getBookAuthor() {
//		return bookAuthor;
//	}
//	public void setBookAuthor(List<Author> bookAuthor) {
//		this.bookAuthor = bookAuthor;
//	}
//	public BookInfo getBookInfo() {
//		return bookInfo;
//	}
//	public void setBookInfo(BookInfo bookInfo) {
//		this.bookInfo = bookInfo;
//	}
}

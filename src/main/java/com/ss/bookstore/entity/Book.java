package com.ss.bookstore.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_book")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public String getBookId() {
//		return bookId;
//	}
//	public void setBookId(String bookId) {
//		this.bookId = bookId;
//	}
//	public String getBookName() {
//		return bookName;
//	}
//	public void setBookName(String bookName) {
//		this.bookName = bookName;
//	}
//	public String getBookKind() {
//		return bookKind;
//	}
//	public void setBookKind(String bookKind) {
//		this.bookKind = bookKind;
//	}
//	public Integer getBookPrice() {
//		return bookPrice;
//	}
//	public void setBookPrice(Integer bookPrice) {
//		this.bookPrice = bookPrice;
//	}
//	public String getBookCoverPic() {
//		return bookCoverPic;
//	}
//	public void setBookCoverPic(String bookCoverPic) {
//		this.bookCoverPic = bookCoverPic;
//	}
//	public String getBookIntro() {
//		return bookIntro;
//	}
//	public void setBookIntro(String bookIntro) {
//		this.bookIntro = bookIntro;
//	}
//	public Boolean getIsJoiningActivity() {
//		return isJoiningActivity;
//	}
//	public void setIsJoiningActivity(Boolean isJoiningActivity) {
//		this.isJoiningActivity = isJoiningActivity;
//	}
//	public Integer getBookStatus() {
//		return bookStatus;
//	}
//	public void setBookStatus(Integer bookStatus) {
//		this.bookStatus = bookStatus;
//	}
//	public String getBookPublisher() {
//		return bookPublisher;
//	}
//	public void setBookPublisher(String bookPublisher) {
//		this.bookPublisher = bookPublisher;
//	}
//	public String getBookPublishDate() {
//		return bookPublishDate;
//	}
//	public void setBookPublishDate(String bookPublishDate) {
//		this.bookPublishDate = bookPublishDate;
//	}
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
//	public Book(){}
//	public Book(String bookId, String bookName, String bookKind, Integer bookPrice, String bookCoverPic,
//			String bookIntro, Boolean isJoiningActivity, Integer bookStatus, String bookPublisher,
//			String bookPublishDate) {
//		this.bookId = bookId;
//		this.bookName = bookName;
//		this.bookKind = bookKind;
//		this.bookPrice = bookPrice;
//		this.bookCoverPic = bookCoverPic;
//		this.bookIntro = bookIntro;
//		this.isJoiningActivity = isJoiningActivity;
//		this.bookStatus = bookStatus;
//		this.bookPublisher = bookPublisher;
//		this.bookPublishDate = bookPublishDate;
//	}
//	@Override
//	public String toString() {
//		return "Book [id=" + id + ", bookId=" + bookId + ", bookName=" + bookName + ", bookKind=" + bookKind
//				+ ", bookPrice=" + bookPrice + ", bookCoverPic=" + bookCoverPic + ", bookIntro=" + bookIntro
//				+ ", isJoiningActivity=" + isJoiningActivity + ", bookStatus=" + bookStatus + ", bookPublisher="
//				+ bookPublisher + ", bookPublishDate=" + bookPublishDate + ", bookAuthor=" + bookAuthor + ", bookInfo="
//				+ bookInfo + "]";
//	}
}

package com.ss.bookstore.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.deser.BeanDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.jackson.JsonComponent;

@TableName("t_book")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book implements Serializable {
	private static final long serialVersionUID = 597733879789573558L;
	@TableId
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
}

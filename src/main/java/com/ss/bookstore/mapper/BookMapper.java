package com.ss.bookstore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ss.bookstore.entity.Book;

public interface BookMapper extends BaseMapper<Book> {
	Book getBookByBookId(Long bookId);
	Integer insertBook(Book book);
}

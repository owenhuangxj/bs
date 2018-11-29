package com.ss.bookstore.service;

import com.ss.bookstore.entity.Book;
import com.ss.bookstore.util.JsonData;

public interface BookService {
    Boolean createBook(Book book);
}

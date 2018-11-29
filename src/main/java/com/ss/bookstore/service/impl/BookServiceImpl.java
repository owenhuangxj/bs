package com.ss.bookstore.service.impl;

import com.ss.bookstore.entity.Book;
import com.ss.bookstore.mapper.BookMapper;
import com.ss.bookstore.service.BookService;
import com.ss.bookstore.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bm;

    @Override
    public Boolean createBook(Book book) {
        return bm.insert(book) > 0;
    }
}

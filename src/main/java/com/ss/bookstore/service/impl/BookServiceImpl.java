package com.ss.bookstore.service.impl;

import com.ss.bookstore.service.BookService;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public class BookServiceImpl implements BookService {

}

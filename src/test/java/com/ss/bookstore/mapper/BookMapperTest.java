package com.ss.bookstore.mapper;

import com.ss.bookstore.BookstoreApplication;
import com.ss.bookstore.entity.Book;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookMapperTest {
    @Autowired
    private BookMapper bm;
    @Test
    public void testInsert(){
        Book book = new Book();
        book.setBookId(UUID.randomUUID().toString());
        book.setBookCoverPic("OwenHuang.jpg");
        book.setBookIntro("It's wonderful book that help me from 自怨自艾");
        book.setBookPrice(156);
        book.setBookPublishDate("2014-9-18");
        book.setBookStatus(1);
        Assert.assertEquals(1,bm.insert(book));
    }
}

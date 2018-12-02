package com.ss.bookstore.mapper;

import com.alibaba.druid.sql.PagerUtils;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ss.bookstore.BookstoreApplication;
import com.ss.bookstore.entity.Book;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

@SuppressWarnings("ALL")
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
        book.setBookIntro("It's wonderful book that help me from blaming self");
        book.setBookPrice(156);
        book.setBookPublishDate("2014-9-18");
        book.setBookStatus(1);
        Assert.assertEquals(1,bm.insert(book));
    }
    @Test
    public void testSelectList(){
        List<Book> books = bm.selectList(null);
        Assert.assertTrue(books.size() > 0);
    }
    @Test
    public void testSelectList2(){
        List<Book> books = bm.selectList(new QueryWrapper<Book>().like("book_name","125"));
        books.forEach(book -> System.out.println(book));
    }
    @Test
    public void testSelectList3(){
        List<Book> books = bm.selectList(
                new QueryWrapper<Book>()
                    .like("book_name","5")
                    .eq("book_kind","历史")

        );
        books.forEach(book -> System.out.println(book));
    }

    @Test
    public void testSelectList4(){
        List<Book> books = bm.selectList(
                new QueryWrapper<Book>()
                    .like("book_name","5")
                    .eq("book_kind","玄幻")
                    .gt("book_price","5000")

        );
        books.forEach(book -> System.out.println(book));
    }

    @Test
    public void testSelectList5(){
        List<Book> books = bm.selectList(
                new QueryWrapper<Book>()
                    .like("book_name","5")
                    .eq("book_kind","玄幻")
                    .between("book_price",1000,10000)

        );
        books.forEach(book -> System.out.println(book));
    }

    @Test
    public void testSelectPage(){
        IPage<Book> page = new Page<Book>(1,20);
        IPage<Book> bookIPage= bm.selectPage(page,new QueryWrapper<Book>().eq("book_kind","玄幻").gt("book_price",5000)
        );
        Assert.assertSame(page,bookIPage);
        System.out.println("总条数 ： " + bookIPage.getTotal());
        System.out.println("每页显示条数 ：" + bookIPage.getSize());
        System.out.println("当前显示页数 ： " + bookIPage.getCurrent());
        List<Book> books = bookIPage.getRecords();

        books.forEach(book -> System.out.println(book));
    }

}

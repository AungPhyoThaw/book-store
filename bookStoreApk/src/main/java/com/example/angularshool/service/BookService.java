package com.example.angularshool.service;

import com.example.angularshool.ds.dao.CategoryDao;
import com.example.angularshool.ds.dao.BookDao;
import com.example.angularshool.ds.Category;
import com.example.angularshool.ds.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {
    private final BookDao bookDao;
    private final CategoryDao categoryDao;

    public BookService(BookDao bookDao, CategoryDao categoryDao) {
        this.bookDao = bookDao;
        this.categoryDao = categoryDao;
    }


    @Transactional
    public Book findBook(int id){
        return bookDao.getById(id);

    }

    @Transactional
    public List<Book> findAll(){
        return bookDao.findAll();
    }

    @Transactional
    public Book saveBook(int cadId, Book book){

        Category category= categoryDao.getById(cadId);
        return  bookDao.save(category.addBook(book));

    }
    @Transactional
    public void removeBook(int bookId){
        Book book=findBook(bookId);
        book.getCategory().remove();
        bookDao.delete(book);
    }

    @Transactional //implexit update,no need database

    public Book updateBook(int bookId, Book newBook, int catId){
        Book oldBook=findBook(bookId);

       Category category=categoryDao.getById(catId);

       oldBook.setTitle(newBook.getTitle());
       oldBook.setAuthor(newBook.getAuthor());
       oldBook.setPrice(newBook.getPrice());
       oldBook.setImageUrl(newBook.getImageUrl());

        category.addBook(oldBook);

        return oldBook;
    }


}

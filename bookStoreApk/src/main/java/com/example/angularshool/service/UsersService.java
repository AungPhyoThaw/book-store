package com.example.angularshool.service;

import com.example.angularshool.ds.dao.BookDao;
import com.example.angularshool.ds.dao.UserBookDao;
import com.example.angularshool.ds.dao.UsersDao;
import com.example.angularshool.ds.Book;
import com.example.angularshool.ds.BookDto;
import com.example.angularshool.ds.UserBook;
import com.example.angularshool.ds.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService {
    @Autowired
    private UsersDao usersDao;
    @Autowired
    private BookDao bookDao;
    @Autowired
    private CartService cartService;
    @Autowired
    private UserBookDao userBookDao;


    @Transactional
    public void checkOut(Users users, List<BookDto>books) {
        UserBook userBook=new UserBook();
        userBook.setUsers(usersDao.save(users));
        List<Book> bookList = bookDtoToEntity(books);

        for (Book book:bookList){
            userBook.addBook(book);
        }
        userBookDao.save(userBook);


    }
    public List<Book> bookDtoToEntity(List<BookDto> bookDtos){
        List<Book> books=new ArrayList<>();
        for (BookDto bookDto:bookDtos){
            books.add(bookDao.getById(bookDto.getId()));
        }
        return books;
    }
    @Transactional
    public List<Book> getBooksByUserId(int userId){
        return userBookDao.findUserBookByUserId(userId)
                .getBookList();
    }

}

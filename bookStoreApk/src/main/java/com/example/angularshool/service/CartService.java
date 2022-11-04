package com.example.angularshool.service;

import com.example.angularshool.ds.Book;
import com.example.angularshool.ds.BookCart;
import com.example.angularshool.ds.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private BookCart bookCartt;

    public int cartSize=0;

    public void  addToCart(Book book){
       // if(!courseCart.getCourses().contains(course)) {
          bookCartt.addBook(book);
        updateCartSize();
        //}
    }

    private void updateCartSize() {
        cartSize =bookCartt.getBooks().size();
    }

    public List<BookDto> allBooksInCart(){
        return bookCartt.getBooks();
    }

    public void clearCart(){
        bookCartt.clearCart();
        updateCartSize();
    }

    public void removeCartBook(Book book){
        bookCartt.removeBook(book);
        updateCartSize();

    }



}
